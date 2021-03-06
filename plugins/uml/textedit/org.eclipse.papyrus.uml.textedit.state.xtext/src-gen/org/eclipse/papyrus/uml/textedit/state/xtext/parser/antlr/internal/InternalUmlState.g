/*
 * generated by Xtext
 */
grammar InternalUmlState;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.state.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.state.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.state.xtext.services.UmlStateGrammarAccess;

}

@parser::members {

 	private UmlStateGrammarAccess grammarAccess;
 	
    public InternalUmlStateParser(TokenStream input, UmlStateGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "StateRule";	
   	}
   	
   	@Override
   	protected UmlStateGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleStateRule
entryRuleStateRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStateRuleRule()); }
	 iv_ruleStateRule=ruleStateRule 
	 { $current=$iv_ruleStateRule.current; } 
	 EOF 
;

// Rule StateRule
ruleStateRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStateRuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"org.eclipse.papyrus.uml.alf.Common.ID");
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getStateRuleAccess().getColonKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0()); 
	    }
		lv_submachine_2_0=ruleSubmachineRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRuleRule());
	        }
       		set(
       			$current, 
       			"submachine",
        		lv_submachine_2_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.SubmachineRule");
	        afterParserOrEnumRuleCall();
	    }

)
))?(

(
	{ 
	  getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
	}
	(
		(

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0()); 
	    }
		lv_entry_4_0=ruleEntryRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRuleRule());
	        }
       		set(
       			$current, 
       			"entry",
        		lv_entry_4_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.EntryRule");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0()); 
	    }
		lv_do_5_0=ruleDoRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRuleRule());
	        }
       		set(
       			$current, 
       			"do",
        		lv_do_5_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.DoRule");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
	 				}
 				)
			)  |

			( 
				{getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)}?=>(
					{ 
	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2);
	 				}
					({true}?=>(
(
		{ 
	        newCompositeNode(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0()); 
	    }
		lv_exit_6_0=ruleExitRule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStateRuleRule());
	        }
       		set(
       			$current, 
       			"exit",
        		lv_exit_6_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.ExitRule");
	        afterParserOrEnumRuleCall();
	    }

)
))
					{ 
	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
	 				}
 				)
			)  

		)*	
	)
)
	{ 
	  getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
	}

))
;





// Entry rule entryRuleSubmachineRule
entryRuleSubmachineRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSubmachineRuleRule()); }
	 iv_ruleSubmachineRule=ruleSubmachineRule 
	 { $current=$iv_ruleSubmachineRule.current; } 
	 EOF 
;

// Rule SubmachineRule
ruleSubmachineRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
	    }
		lv_path_0_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSubmachineRuleRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_0_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSubmachineRuleRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current; } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getQualifiedNameRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
	}

)
)	otherlv_1='::' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_remaining_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
	        }
       		set(
       			$current, 
       			"remaining",
        		lv_remaining_2_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleEntryRule
entryRuleEntryRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEntryRuleRule()); }
	 iv_ruleEntryRule=ruleEntryRule 
	 { $current=$iv_ruleEntryRule.current; } 
	 EOF 
;

// Rule EntryRule
ruleEntryRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='entry' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getEntryRuleAccess().getEntryKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
	    }
		lv_kind_1_0=ruleBehaviorKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEntryRuleRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_1_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_behaviorName_2_0=RULE_ID
		{
			newLeafNode(lv_behaviorName_2_0, grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getEntryRuleRule());
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





// Entry rule entryRuleDoRule
entryRuleDoRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDoRuleRule()); }
	 iv_ruleDoRule=ruleDoRule 
	 { $current=$iv_ruleDoRule.current; } 
	 EOF 
;

// Rule DoRule
ruleDoRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='do' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getDoRuleAccess().getDoKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
	    }
		lv_kind_1_0=ruleBehaviorKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDoRuleRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_1_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_behaviorName_2_0=RULE_ID
		{
			newLeafNode(lv_behaviorName_2_0, grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDoRuleRule());
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





// Entry rule entryRuleExitRule
entryRuleExitRule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExitRuleRule()); }
	 iv_ruleExitRule=ruleExitRule 
	 { $current=$iv_ruleExitRule.current; } 
	 EOF 
;

// Rule ExitRule
ruleExitRule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='exit' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getExitRuleAccess().getExitKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
	    }
		lv_kind_1_0=ruleBehaviorKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getExitRuleRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_1_0, 
        		"org.eclipse.papyrus.uml.textedit.state.xtext.UmlState.BehaviorKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_behaviorName_2_0=RULE_ID
		{
			newLeafNode(lv_behaviorName_2_0, grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getExitRuleRule());
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


