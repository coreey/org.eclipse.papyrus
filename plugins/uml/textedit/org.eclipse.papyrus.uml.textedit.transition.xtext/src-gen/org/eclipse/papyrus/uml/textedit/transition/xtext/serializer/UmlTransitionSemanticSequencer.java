/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlTransitionSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlTransitionGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UmlTransitionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlTransitionPackage.ABSOLUTE_TIME_EVENT_RULE:
				sequence_AbsoluteTimeEventRule(context, (AbsoluteTimeEventRule) semanticObject);
				return;
			case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE:
				sequence_AnyReceiveEventRule(context, (AnyReceiveEventRule) semanticObject);
				return;
			case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE:
				sequence_CallOrSignalEventRule(context, (CallOrSignalEventRule) semanticObject);
				return;
			case UmlTransitionPackage.CHANGE_EVENT_RULE:
				sequence_ChangeEventRule(context, (ChangeEventRule) semanticObject);
				return;
			case UmlTransitionPackage.EFFECT_RULE:
				sequence_EffectRule(context, (EffectRule) semanticObject);
				return;
			case UmlTransitionPackage.GUARD_RULE:
				sequence_GuardRule(context, (GuardRule) semanticObject);
				return;
			case UmlTransitionPackage.RELATIVE_TIME_EVENT_RULE:
				sequence_RelativeTimeEventRule(context, (RelativeTimeEventRule) semanticObject);
				return;
			case UmlTransitionPackage.TRANSITION_RULE:
				sequence_TransitionRule(context, (TransitionRule) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * EventRule returns AbsoluteTimeEventRule
	 * TimeEventRule returns AbsoluteTimeEventRule
	 * AbsoluteTimeEventRule returns AbsoluteTimeEventRule
	 *
	 * Constraint:
	 * expr=STRING
	 */
	protected void sequence_AbsoluteTimeEventRule(ISerializationContext context, AbsoluteTimeEventRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * EventRule returns AnyReceiveEventRule
	 * AnyReceiveEventRule returns AnyReceiveEventRule
	 *
	 * Constraint:
	 * isAReceiveEvent='all'
	 */
	protected void sequence_AnyReceiveEventRule(ISerializationContext context, AnyReceiveEventRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0(), semanticObject.getIsAReceiveEvent());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * EventRule returns CallOrSignalEventRule
	 * CallOrSignalEventRule returns CallOrSignalEventRule
	 *
	 * Constraint:
	 * operationOrSignal=[NamedElement|ID]
	 */
	protected void sequence_CallOrSignalEventRule(ISerializationContext context, CallOrSignalEventRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1(), semanticObject.eGet(UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL, false));
		feeder.finish();
	}


	/**
	 * Contexts:
	 * EventRule returns ChangeEventRule
	 * ChangeEventRule returns ChangeEventRule
	 *
	 * Constraint:
	 * exp=STRING
	 */
	protected void sequence_ChangeEventRule(ISerializationContext context, ChangeEventRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.CHANGE_EVENT_RULE__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.CHANGE_EVENT_RULE__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0(), semanticObject.getExp());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * EffectRule returns EffectRule
	 *
	 * Constraint:
	 * (kind=BehaviorKind behaviorName=ID)
	 */
	protected void sequence_EffectRule(ISerializationContext context, EffectRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__KIND));
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__BEHAVIOR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.EFFECT_RULE__BEHAVIOR_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), semanticObject.getBehaviorName());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * GuardRule returns GuardRule
	 *
	 * Constraint:
	 * constraint=STRING
	 */
	protected void sequence_GuardRule(ISerializationContext context, GuardRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.GUARD_RULE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.GUARD_RULE__CONSTRAINT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0(), semanticObject.getConstraint());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * EventRule returns RelativeTimeEventRule
	 * TimeEventRule returns RelativeTimeEventRule
	 * RelativeTimeEventRule returns RelativeTimeEventRule
	 *
	 * Constraint:
	 * expr=STRING
	 */
	protected void sequence_RelativeTimeEventRule(ISerializationContext context, RelativeTimeEventRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlTransitionPackage.Literals.TIME_EVENT_RULE__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * TransitionRule returns TransitionRule
	 *
	 * Constraint:
	 * (
	 * (triggers+=EventRule triggers+=EventRule* ((guard=GuardRule effect=EffectRule) | effect=EffectRule)) |
	 * (guard=GuardRule effect=EffectRule) |
	 * effect=EffectRule
	 * )?
	 */
	protected void sequence_TransitionRule(ISerializationContext context, TransitionRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
