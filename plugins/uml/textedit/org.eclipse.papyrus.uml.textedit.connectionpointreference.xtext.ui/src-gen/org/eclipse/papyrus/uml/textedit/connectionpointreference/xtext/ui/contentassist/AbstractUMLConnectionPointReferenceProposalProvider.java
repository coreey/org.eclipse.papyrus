/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * Represents a generated, default implementation of superclass {@link org.eclipse.papyrus.uml.alf.ui.contentassist.CommonProposalProvider}.
 * Methods are dynamically dispatched on the first parameter, i.e., you can override them
 * with a more concrete subtype.
 */
@SuppressWarnings("all")
public class AbstractUMLConnectionPointReferenceProposalProvider extends org.eclipse.papyrus.uml.alf.ui.contentassist.CommonProposalProvider {

	public void completeConnectionPointReferenceRule_Entry(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
	}

	public void completeConnectionPointReferenceRule_Exit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
	}

	public void complete_ConnectionPointReferenceRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// subclasses may override
	}
}
