/*
 * generated by Xtext
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class CSSAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.tokens");
	}
}
