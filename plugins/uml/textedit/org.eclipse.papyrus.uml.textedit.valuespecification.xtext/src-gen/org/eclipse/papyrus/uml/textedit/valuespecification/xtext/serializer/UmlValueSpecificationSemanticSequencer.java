/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services.UmlValueSpecificationGrammarAccess;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlValueSpecificationSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlValueSpecificationGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UmlValueSpecificationPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlValueSpecificationPackage.ABSTRACT_RULE:
				sequence_AbstractRule(context, (AbstractRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.LITERAL_BOOLEAN_RULE:
				sequence_LiteralBooleanRule(context, (LiteralBooleanRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE:
				sequence_LiteralIntegerOrUnlimitedNaturalRule(context, (LiteralIntegerOrUnlimitedNaturalRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.LITERAL_NULL_RULE:
				sequence_LiteralNullRule(context, (LiteralNullRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.LITERAL_REAL_RULE:
				sequence_LiteralRealRule(context, (LiteralRealRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.LITERAL_STRING_RULE:
				sequence_LiteralStringRule(context, (LiteralStringRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.UNDEFINED_RULE:
				sequence_UndefinedRule(context, (UndefinedRule) semanticObject);
				return;
			case UmlValueSpecificationPackage.VISIBILITY_KIND:
				sequence_VisibilityKind(context, (VisibilityKind) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * AbstractRule returns AbstractRule
	 *
	 * Constraint:
	 * (
	 * visibility=VisibilityKind?
	 * name=VALUE_SPECIFICATION_ID?
	 * (
	 * instanceSpecification=[InstanceSpecification|ID] |
	 * value=LiteralBooleanRule |
	 * value=LiteralIntegerOrUnlimitedNaturalRule |
	 * value=LiteralRealRule |
	 * value=LiteralNullRule |
	 * value=LiteralStringRule |
	 * undefined=UndefinedRule
	 * )
	 * )
	 */
	protected void sequence_AbstractRule(ISerializationContext context, AbstractRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * LiteralBooleanRule returns LiteralBooleanRule
	 *
	 * Constraint:
	 * (value='true' | value='false')
	 */
	protected void sequence_LiteralBooleanRule(ISerializationContext context, LiteralBooleanRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * LiteralIntegerOrUnlimitedNaturalRule returns LiteralIntegerOrUnlimitedNaturalRule
	 *
	 * Constraint:
	 * (value=INT | value=VALUE_SPECIFICATION_NEGATIVE_INT | unlimited='*')
	 */
	protected void sequence_LiteralIntegerOrUnlimitedNaturalRule(ISerializationContext context, LiteralIntegerOrUnlimitedNaturalRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * LiteralNullRule returns LiteralNullRule
	 *
	 * Constraint:
	 * value='null'
	 */
	protected void sequence_LiteralNullRule(ISerializationContext context, LiteralNullRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_NULL_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_NULL_RULE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * LiteralRealRule returns LiteralRealRule
	 *
	 * Constraint:
	 * value=VALUE_SPECIFICATION_DOUBLE
	 */
	protected void sequence_LiteralRealRule(ISerializationContext context, LiteralRealRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_REAL_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_REAL_RULE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * LiteralStringRule returns LiteralStringRule
	 *
	 * Constraint:
	 * value=STRING
	 */
	protected void sequence_LiteralStringRule(ISerializationContext context, LiteralStringRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_STRING_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_STRING_RULE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * UndefinedRule returns UndefinedRule
	 *
	 * Constraint:
	 * value='<Undefined>'
	 */
	protected void sequence_UndefinedRule(ISerializationContext context, UndefinedRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.UNDEFINED_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.UNDEFINED_RULE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * VisibilityKind returns VisibilityKind
	 *
	 * Constraint:
	 * (public='+' | private='-' | protected='#' | package='~')
	 */
	protected void sequence_VisibilityKind(ISerializationContext context, VisibilityKind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
