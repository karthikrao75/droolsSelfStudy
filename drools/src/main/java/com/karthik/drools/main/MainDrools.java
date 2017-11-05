package com.karthik.drools.main;

import java.io.IOException;

import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.kie.builder.impl.KieBuilderImpl;
import org.drools.core.definitions.impl.KnowledgePackageImpl;
import org.kie.api.KieBase;
import org.kie.api.builder.KieBuilder;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.io.ResourceFactory;

import com.karthik.drools.model.Product;

public class MainDrools {

	public static void main(String[] args) throws DroolsParserException, IOException {
		MainDrools drools = new MainDrools();
		drools.executeDrools();

	}

	public void executeDrools() throws DroolsParserException, IOException {
		KnowledgeBuilder builder = new KnowledgeBuilderImpl();

		builder.add(ResourceFactory.newClassPathResource("com/rule/Rule.drl"), ResourceType.DRL);
		builder.batch();
		System.out.println(builder.getErrors());
		KieBase base = builder.newKieBase();
		StatelessKieSession kieSession = base.newStatelessKieSession();

		Product product = new Product();
		product.setType("gold");

		kieSession.execute(product);
/*		
		PackageBuilder packageBuilder = new PackageBuilder();

		
		packageBuilder.addPackageFromDrl(ResourceFactory.newClassPathResource("com/rule"));
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		

		workingMemory.insert(product);
		workingMemory.fireAllRules();
*/

		System.out.println("The discount for the product " + product.getType()
				+ " is " + product.getDiscount());

	}
}
