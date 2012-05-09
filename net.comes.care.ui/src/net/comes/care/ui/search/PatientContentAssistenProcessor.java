package net.comes.care.ui.search;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.comes.care.entity.Patient;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

/**
 * 
 * @author Nepomuk Seiler
 * @version 0.1
 * @since 2012-05-08
 * 
 */
@Creatable
public class PatientContentAssistenProcessor implements IContentAssistProcessor {

	private static final char[] ACTIVATION_CHARS = new char[2 * 26 + 10];

	static {
		int index = 0;
		for (char ch = 'a'; ch <= 'z'; ch++)
			ACTIVATION_CHARS[index++] = ch;

		for (char ch = 'A'; ch <= 'Z'; ch++)
			ACTIVATION_CHARS[index++] = ch;

		for (int i = 0; i < 10; i++)
			ACTIVATION_CHARS[index++] = String.valueOf(i).charAt(0);

	}

	private final IContextInformationValidator validator;

	@Inject
	@GeminiPersistenceContext(unitName = "comes")
	private EntityManager em;

	public PatientContentAssistenProcessor() {
		validator = new ContextInformationValidator(this);
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		// 1. Get input
		// 2. Load patients which start with <string>
		final String searchText = viewer.getDocument().get();

		em.getTransaction().begin();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Patient> query = criteriaBuilder.createQuery(Patient.class);

		//TODO Query does not filter for insurance ids and shows all users, not only patients
		/* === Query database for possible patients === */
		Root<Patient> patientRoot = query.from(Patient.class);
		Join<Object, Object> patientJoin = patientRoot.join("user");
		Predicate nameLike = criteriaBuilder.like(patientJoin.<String> get("name"), "%" + searchText + "%"); //Starts or end with
		Predicate surnameLike = criteriaBuilder.like(patientJoin.<String> get("surname"), "%" + searchText + "%");
		// Predicate insuranceLike =
		// criteriaBuilder.like(patientJoin.<String>get("insuranceNumber"),
		// searchText);
		Predicate predicate = criteriaBuilder.or(nameLike, surnameLike);
		query = query.select(patientRoot).where(predicate);
		List<Patient> patients = em.createQuery(query).getResultList();

		em.getTransaction().commit();

		ICompletionProposal[] returns = new ICompletionProposal[patients.size()];
		int i = 0;
		for (Patient patient : patients) {
			String suggestion = patient.getUser().getSurname() + " " + patient.getUser().getName() + " #" + patient.getInsuranceNumber();
			CompletionProposal proposal = new CompletionProposal(suggestion, 0, searchText.length(), suggestion.length());
			returns[i++] = proposal;
		}

		return returns;
	}

	@Override
	public String getErrorMessage() {
		return "Error Message";
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return validator;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return ACTIVATION_CHARS;
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		// Show patient picture and some data
		return null;
	}

}
