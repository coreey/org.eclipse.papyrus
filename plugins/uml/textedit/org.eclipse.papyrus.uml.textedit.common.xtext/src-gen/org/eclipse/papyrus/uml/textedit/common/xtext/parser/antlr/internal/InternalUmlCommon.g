/*
 * generated by Xtext
 */
grammar InternalUmlCommon;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;

}

@parser::members {

 	private UmlCommonGrammarAccess grammarAccess;
 	
    public InternalUmlCommonParser(TokenStream input, UmlCommonGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "QualifiedName";	
   	}
   	
   	@Override
   	protected UmlCommonGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




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
        		"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;









// Entry rule entryRuleBoundSpecification
entryRuleBoundSpecification returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBoundSpecificationRule()); }
	 iv_ruleBoundSpecification=ruleBoundSpecification 
	 { $current=$iv_ruleBoundSpecification.current; } 
	 EOF 
;

// Rule BoundSpecification
ruleBoundSpecification returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
	    }
		lv_value_0_0=ruleUnlimitedLiteral		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_0_0, 
        		"org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon.UnlimitedLiteral");
	        afterParserOrEnumRuleCall();
	    }

)
)
;





// Entry rule entryRuleUnlimitedLiteral
entryRuleUnlimitedLiteral returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); } 
	 iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral 
	 { $current=$iv_ruleUnlimitedLiteral.current.getText(); }  
	 EOF 
;

// Rule UnlimitedLiteral
ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
    }

    |
	kw='*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
    }
)
    ;









RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'\'' ( options {greedy=false;} : . )*'\'');

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_ML_COMMENT : '/*' ~('@') ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'|'@'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_INTEGER_VALUE : (('0'|'1'..'9' ('_'? '0'..'9')*)|('0b'|'0B') '0'..'1' ('_'? '0'..'1')*|('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F') ('_'? ('0'..'9'|'a'..'f'|'A'..'F'))*|'0' '_'? '0'..'7' ('_'? '0'..'7')*);

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


