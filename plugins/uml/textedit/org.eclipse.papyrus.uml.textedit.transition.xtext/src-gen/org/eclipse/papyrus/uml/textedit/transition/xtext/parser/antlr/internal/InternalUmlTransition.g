/*
 * generated by Xtext
 */
grammar InternalUmlTransition;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;

}

@parser::members {

 	private UmlTransitionGrammarAccess grammarAccess;
 	
    public InternalUmlTransitionParser(TokenStream input, UmlTransitionGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "TransitionRule";	
   	}
   	
   	@Override
   	protected UmlTransitionGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleTransitionRule
entryRuleTransitionRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTransitionRuleRule()); }
	 iv_ruleTransitionRule=ruleTransitionRule 
	 { $current=$iv_ruleTransitionRule.current; } 
	 EOF 
;

// Rule TransitionRule
ruleTransitionRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_0_0()); 
	    }
		lv_triggers_0_0=ruleEventRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
	        }
       		add(
       			$current, 
       			"triggers",
        		lv_triggers_0_0, 
        		"org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransition.EventRule");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=',' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_1_1_0()); 
	    }
		lv_triggers_2_0=ruleEventRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
	        }
       		add(
       			$current, 
       			"triggers",
        		lv_triggers_2_0, 
        		"org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransition.EventRule");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0()); 
	    }
		lv_guard_3_0=ruleGuardRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
	        }
       		set(
       			$current, 
       			"guard",
        		lv_guard_3_0, 
        		"org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransition.GuardRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_2_0()); 
	    }
		lv_effect_4_0=ruleEffectRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
	        }
       		set(
       			$current, 
       			"effect",
        		lv_effect_4_0, 
        		"org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransition.EffectRule");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleEventRule
entryRuleEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventRuleRule()); }
	 iv_ruleEventRule=ruleEventRule 
	 { $current=$iv_ruleEventRule.current; } 
	 EOF 
;

// Rule EventRule
ruleEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0()); 
    }
    this_CallOrSignalEventRule_0=ruleCallOrSignalEventRule
    { 
        $current = $this_CallOrSignalEventRule_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1()); 
    }
    this_AnyReceiveEventRule_1=ruleAnyReceiveEventRule
    { 
        $current = $this_AnyReceiveEventRule_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2()); 
    }
    this_TimeEventRule_2=ruleTimeEventRule
    { 
        $current = $this_TimeEventRule_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3()); 
    }
    this_ChangeEventRule_3=ruleChangeEventRule
    { 
        $current = $this_ChangeEventRule_3.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleCallOrSignalEventRule
entryRuleCallOrSignalEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCallOrSignalEventRuleRule()); }
	 iv_ruleCallOrSignalEventRule=ruleCallOrSignalEventRule 
	 { $current=$iv_ruleCallOrSignalEventRule.current; } 
	 EOF 
;

// Rule CallOrSignalEventRule
ruleCallOrSignalEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCallOrSignalEventRuleRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0()); 
	}

)
)
;





// Entry rule entryRuleAnyReceiveEventRule
entryRuleAnyReceiveEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAnyReceiveEventRuleRule()); }
	 iv_ruleAnyReceiveEventRule=ruleAnyReceiveEventRule 
	 { $current=$iv_ruleAnyReceiveEventRule.current; } 
	 EOF 
;

// Rule AnyReceiveEventRule
ruleAnyReceiveEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_isAReceiveEvent_0_0=	'all' 
    {
        newLeafNode(lv_isAReceiveEvent_0_0, grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAnyReceiveEventRuleRule());
	        }
       		setWithLastConsumed($current, "isAReceiveEvent", lv_isAReceiveEvent_0_0, "all");
	    }

)
)
;





// Entry rule entryRuleTimeEventRule
entryRuleTimeEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTimeEventRuleRule()); }
	 iv_ruleTimeEventRule=ruleTimeEventRule 
	 { $current=$iv_ruleTimeEventRule.current; } 
	 EOF 
;

// Rule TimeEventRule
ruleTimeEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0()); 
    }
    this_RelativeTimeEventRule_0=ruleRelativeTimeEventRule
    { 
        $current = $this_RelativeTimeEventRule_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1()); 
    }
    this_AbsoluteTimeEventRule_1=ruleAbsoluteTimeEventRule
    { 
        $current = $this_AbsoluteTimeEventRule_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleRelativeTimeEventRule
entryRuleRelativeTimeEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRelativeTimeEventRuleRule()); }
	 iv_ruleRelativeTimeEventRule=ruleRelativeTimeEventRule 
	 { $current=$iv_ruleRelativeTimeEventRule.current; } 
	 EOF 
;

// Rule RelativeTimeEventRule
ruleRelativeTimeEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='after' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0());
    }
(
(
		lv_expr_1_0=RULE_STRING
		{
			newLeafNode(lv_expr_1_0, grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRelativeTimeEventRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"expr",
        		lv_expr_1_0, 
        		"org.eclipse.papyrus.uml.alf.Common.STRING");
	    }

)
))
;





// Entry rule entryRuleAbsoluteTimeEventRule
entryRuleAbsoluteTimeEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAbsoluteTimeEventRuleRule()); }
	 iv_ruleAbsoluteTimeEventRule=ruleAbsoluteTimeEventRule 
	 { $current=$iv_ruleAbsoluteTimeEventRule.current; } 
	 EOF 
;

// Rule AbsoluteTimeEventRule
ruleAbsoluteTimeEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='at' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0());
    }
(
(
		lv_expr_1_0=RULE_STRING
		{
			newLeafNode(lv_expr_1_0, grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAbsoluteTimeEventRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"expr",
        		lv_expr_1_0, 
        		"org.eclipse.papyrus.uml.alf.Common.STRING");
	    }

)
))
;





// Entry rule entryRuleChangeEventRule
entryRuleChangeEventRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getChangeEventRuleRule()); }
	 iv_ruleChangeEventRule=ruleChangeEventRule 
	 { $current=$iv_ruleChangeEventRule.current; } 
	 EOF 
;

// Rule ChangeEventRule
ruleChangeEventRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='when' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0());
    }
(
(
		lv_exp_1_0=RULE_STRING
		{
			newLeafNode(lv_exp_1_0, grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getChangeEventRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exp",
        		lv_exp_1_0, 
        		"org.eclipse.papyrus.uml.alf.Common.STRING");
	    }

)
))
;





// Entry rule entryRuleGuardRule
entryRuleGuardRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGuardRuleRule()); }
	 iv_ruleGuardRule=ruleGuardRule 
	 { $current=$iv_ruleGuardRule.current; } 
	 EOF 
;

// Rule GuardRule
ruleGuardRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());
    }
(
(
		lv_constraint_1_0=RULE_STRING
		{
			newLeafNode(lv_constraint_1_0, grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGuardRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"constraint",
        		lv_constraint_1_0, 
        		"org.eclipse.papyrus.uml.alf.Common.STRING");
	    }

)
)	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());
    }
)
;





// Entry rule entryRuleEffectRule
entryRuleEffectRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEffectRuleRule()); }
	 iv_ruleEffectRule=ruleEffectRule 
	 { $current=$iv_ruleEffectRule.current; } 
	 EOF 
;

// Rule EffectRule
ruleEffectRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='/' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEffectRuleAccess().getSolidusKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
	    }
		lv_kind_1_0=ruleBehaviorKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEffectRuleRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_1_0, 
        		"org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransition.BehaviorKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_behaviorName_2_0=RULE_ID
		{
			newLeafNode(lv_behaviorName_2_0, grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEffectRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"behaviorName",
        		lv_behaviorName_2_0, 
        		"org.eclipse.papyrus.uml.alf.Common.ID");
	    }

)
))
;





// Rule BehaviorKind
ruleBehaviorKind returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='Activity' 
	{
        $current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='StateMachine' 
	{
        $current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='OpaqueBehavior' 
	{
        $current = grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 
    }
));



RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'\'' ( options {greedy=false;} : . )*'\'');

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_ML_COMMENT : '/*' ~('@') ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'|'@'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_INTEGER_VALUE : (('0'|'1'..'9' ('_'? '0'..'9')*)|('0b'|'0B') '0'..'1' ('_'? '0'..'1')*|('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F') ('_'? ('0'..'9'|'a'..'f'|'A'..'F'))*|'0' '_'? '0'..'7' ('_'? '0'..'7')*);

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


