/*
 * Copyright (C) 2010-2018 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * Copyright (C) 2021- SmartUt contributors
 *
 * SmartUt is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * SmartUt is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with SmartUt. If not, see <http://www.gnu.org/licenses/>.
 */

package org.smartut.testsuite.factories;

import org.smartut.Properties;
import org.smartut.ga.ChromosomeFactory;
import org.smartut.testcase.TestChromosome;
import org.smartut.testcase.factories.RandomLengthTestFactory;
import org.smartut.testsuite.TestSuiteChromosome;
import org.smartut.utils.Randomness;


/**
 * <p>JUnitTestSuiteChromosomeFactory class.</p>
 *
 * @author fraser
 */
public class JUnitTestSuiteChromosomeFactory implements
        ChromosomeFactory<TestSuiteChromosome> {

	private static final long serialVersionUID = 1L;

	private final ChromosomeFactory<TestChromosome> defaultFactory;

	/**
	 * <p>Constructor for JUnitTestSuiteChromosomeFactory.</p>
	 *
	 * @param defaultFactory a {@link org.smartut.ga.ChromosomeFactory} object.
	 */
	public JUnitTestSuiteChromosomeFactory(
	        ChromosomeFactory<TestChromosome> defaultFactory) {
		this.defaultFactory = defaultFactory;
	}

	/* (non-Javadoc)
	 * @see org.smartut.ga.ChromosomeFactory#getChromosome()
	 */
	/** {@inheritDoc} */
	@Override
	public TestSuiteChromosome getChromosome() {
		/*
		double P_delta = 0.1d;
		double P_clone = 0.1d;
		int MAX_CHANGES = 10;
		*/

		TestSuiteChromosome chromosome = new TestSuiteChromosome(
		        new RandomLengthTestFactory());
		chromosome.clearTests();

		int numTests = Randomness.nextInt(Properties.MIN_INITIAL_TESTS,
		                                  Properties.MAX_INITIAL_TESTS + 1);

		for (int i = 0; i < numTests; i++) {
			TestChromosome test = defaultFactory.getChromosome();
			chromosome.addTest(test);
			//chromosome.tests.add(test);
		}

		return chromosome;
	}

}
