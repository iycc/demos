package com.iycc.pattern.strategy;

import com.iycc.pattern.strategy.strategy.AddStrategy;
import com.iycc.pattern.strategy.strategy.DivideStrategy;
import com.iycc.pattern.strategy.strategy.MultiplyStrategy;
import com.iycc.pattern.strategy.strategy.SubtractStrategy;

public class Client
{
	public static void main(String[] args)
	{
		AddStrategy addStrategy = new AddStrategy();

		Environment environment = new Environment(addStrategy);

		System.out.println(environment.calculate(3, 4));

		SubtractStrategy subtractStrategy = new SubtractStrategy();

		environment.setStrategy(subtractStrategy);

		System.out.println(environment.calculate(3, 4));

		MultiplyStrategy multiplyStrategy = new MultiplyStrategy();

		environment.setStrategy(multiplyStrategy);

		System.out.println(environment.calculate(3, 4));

		DivideStrategy divideStrategy = new DivideStrategy();

		environment.setStrategy(divideStrategy);

		System.out.println(environment.calculate(3, 4));

	}
}
