package net.comes.care.ui.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import net.comes.care.entity.Patient;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;

/**
 * 
 * @author Nepomuk Seiler
 * @version 0.1
 * @since 2012-05-08
 * 
 */
public class PatientContentAssistenProcessor implements IContentAssistProcessor {

	private static final char[] ACTIVATION_CHARS = new char[2*26 + 10];
	
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
	private final EntityManager em;

	private List<Patient> patients;

	public PatientContentAssistenProcessor() {
		validator = new ContextInformationValidator(this);
		em = null;
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		// 1. Get input
		// 2. Load patients which start with <string>
		final String searchText = viewer.getDocument().get();
		updatePatients(searchText);
		
		Collection<Patient> possibilities = Collections2.filter(patients, new Predicate<Patient>() {
			@Override
			public boolean apply(Patient p) {
				
				Splitter splitter = Splitter.on(" ").
						trimResults()
						.trimResults(CharMatcher.is('#'))
						.omitEmptyStrings();
				Iterable<String> tokens = splitter.split(searchText);
				boolean match = false;
				for (String token : tokens) {
					match = match || p.getUser().getName().contains(token) || p.getUser().getSurname().contains(token) || p.getInsuranceNumber().contains(token);
				}
				return match;
			}
		});

		ICompletionProposal[] returns = new ICompletionProposal[possibilities.size()];
		int i = 0;
		for (Patient patient : possibilities) {
			String suggestion = patient.getUser().getName() + " " + patient.getUser().getSurname() + " #" + patient.getInsuranceNumber();
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

	private void updatePatients(String input) {
		patients = new ArrayList<>();

		Patient patient = new Patient();
		patient.getUser().setName("Max");
		patient.getUser().setSurname("Mustermann");
		patient.setInsuranceNumber("20-M01-1963");
		patients.add(patient);
		
		patient = new Patient();
		patient.getUser().setName("Birgit");
		patient.getUser().setSurname("Mustermann");
		patient.setInsuranceNumber("63-K31-1953");
		patients.add(patient);

		patient = new Patient();
		patient.getUser().setName("Heinz");
		patient.getUser().setSurname("Huber");
		patient.setInsuranceNumber("35-L07-1983");
		patients.add(patient);
	}

}
