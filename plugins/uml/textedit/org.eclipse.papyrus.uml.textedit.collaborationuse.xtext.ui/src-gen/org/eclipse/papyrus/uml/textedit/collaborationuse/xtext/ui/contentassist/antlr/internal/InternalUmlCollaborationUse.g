/*
 * generated by Xtext
 */
grammar InternalUmlCollaborationUse;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services.UmlCollaborationUseGrammarAccess;

}

@parser::members {
 
 	private UmlCollaborationUseGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(UmlCollaborationUseGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleCollaborationUseRule
entryRuleCollaborationUseRule 
:
{ before(grammarAccess.getCollaborationUseRuleRule()); }
	 ruleCollaborationUseRule
{ after(grammarAccess.getCollaborationUseRuleRule()); } 
	 EOF 
;

// Rule CollaborationUseRule
ruleCollaborationUseRule
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getGroup()); }
(rule__CollaborationUseRule__Group__0)
{ after(grammarAccess.getCollaborationUseRuleAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleTypeRule
entryRuleTypeRule 
:
{ before(grammarAccess.getTypeRuleRule()); }
	 ruleTypeRule
{ after(grammarAccess.getTypeRuleRule()); } 
	 EOF 
;

// Rule TypeRule
ruleTypeRule
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getTypeRuleAccess().getGroup()); }
(rule__TypeRule__Group__0)
{ after(grammarAccess.getTypeRuleAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleQualifiedName
entryRuleQualifiedName 
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
(rule__QualifiedName__Group__0)
{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleBoundSpecification
entryRuleBoundSpecification 
:
{ before(grammarAccess.getBoundSpecificationRule()); }
	 ruleBoundSpecification
{ after(grammarAccess.getBoundSpecificationRule()); } 
	 EOF 
;

// Rule BoundSpecification
ruleBoundSpecification
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); }
(rule__BoundSpecification__ValueAssignment)
{ after(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleUnlimitedLiteral
entryRuleUnlimitedLiteral 
:
{ before(grammarAccess.getUnlimitedLiteralRule()); }
	 ruleUnlimitedLiteral
{ after(grammarAccess.getUnlimitedLiteralRule()); } 
	 EOF 
;

// Rule UnlimitedLiteral
ruleUnlimitedLiteral
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); }
(rule__UnlimitedLiteral__Alternatives)
{ after(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




// Rule VisibilityKind
ruleVisibilityKind
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVisibilityKindAccess().getAlternatives()); }
(rule__VisibilityKind__Alternatives)
{ after(grammarAccess.getVisibilityKindAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}





rule__CollaborationUseRule__Alternatives_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0()); }
(rule__CollaborationUseRule__TypeAssignment_3_0)
{ after(grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0()); }
)

    |(
{ before(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1()); }

	'<Undefined>' 

{ after(grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__UnlimitedLiteral__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
{ after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); }

	'*' 

{ after(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__VisibilityKind__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); }
(	'+' 
)
{ after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); }
)

    |(
{ before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); }
(	'-' 
)
{ after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); }
)

    |(
{ before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); }
(	'#' 
)
{ after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); }
)

    |(
{ before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); }
(	'~' 
)
{ after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__CollaborationUseRule__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollaborationUseRule__Group__0__Impl
	rule__CollaborationUseRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0()); }
(rule__CollaborationUseRule__VisibilityAssignment_0)
{ after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollaborationUseRule__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollaborationUseRule__Group__1__Impl
	rule__CollaborationUseRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1()); }
(rule__CollaborationUseRule__NameAssignment_1)
{ after(grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollaborationUseRule__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollaborationUseRule__Group__2__Impl
	rule__CollaborationUseRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2()); }

	':' 

{ after(grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__CollaborationUseRule__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__CollaborationUseRule__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3()); }
(rule__CollaborationUseRule__Alternatives_3)
{ after(grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__TypeRule__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRule__Group__0__Impl
	rule__TypeRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRule__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); }
(rule__TypeRule__PathAssignment_0)?
{ after(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRule__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__TypeRule__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRule__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); }
(rule__TypeRule__TypeAssignment_1)
{ after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__QualifiedName__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); }
(rule__QualifiedName__PathAssignment_0)
{ after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__1__Impl
	rule__QualifiedName__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); }

	'::' 

{ after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); }
(rule__QualifiedName__RemainingAssignment_2)?
{ after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}











rule__CollaborationUseRule__VisibilityAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); }
	ruleVisibilityKind{ after(grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__CollaborationUseRule__TypeAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0()); }
	ruleTypeRule{ after(grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRule__PathAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); }
	ruleQualifiedName{ after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRule__TypeAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0()); }
(
{ before(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1()); }
	RULE_ID{ after(grammarAccess.getTypeRuleAccess().getTypeCollaborationIDTerminalRuleCall_1_0_1()); }
)
{ after(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__PathAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); }
(
{ before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__RemainingAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); }
	ruleQualifiedName{ after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__BoundSpecification__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); }
	ruleUnlimitedLiteral{ after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : (('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*|'\'' ( options {greedy=false;} : . )*'\'');

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';

RULE_ML_COMMENT : '/*' ~('@') ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'|'@'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_INTEGER_VALUE : (('0'|'1'..'9' ('_'? '0'..'9')*)|('0b'|'0B') '0'..'1' ('_'? '0'..'1')*|('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F') ('_'? ('0'..'9'|'a'..'f'|'A'..'F'))*|'0' '_'? '0'..'7' ('_'? '0'..'7')*);

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


