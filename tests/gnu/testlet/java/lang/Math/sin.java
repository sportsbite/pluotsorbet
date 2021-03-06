// Tags: JDK1.0

/* Copyright (C) 2000 Red Hat

   This file is part of Mauve.

   Mauve is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   Mauve is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with Mauve; see the file COPYING.  If not, write to
   the Free Software Foundation, 59 Temple Place - Suite 330,
   Boston, MA 02111-1307, USA.  */

package gnu.testlet.java.lang.Math;
import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

/**
  * Test for a static method Math.sin()
  */
public class sin implements Testlet
{
  public int getExpectedPass() { return 0; }
  public int getExpectedFail() { return 0; }
  public int getExpectedKnownFail() { return 0; }

  /**
   * Function (=static method) checked by this test.
   */
  private static double testedFunction(double input)
    {
      return Math.sin(input);
    }

  /**
   * These values are used as arguments to compute sin using Math.
   */
  private static double[] inputValues =
    {
      Double.NaN,
      Double.POSITIVE_INFINITY,
      Double.NEGATIVE_INFINITY,
      Double.MAX_VALUE,
      Double.MIN_VALUE,
      0.0,
      Math.PI/4,
      Math.PI/2,
      Math.PI,
      2*Math.PI,
      4*Math.PI,
      100*Math.PI,
      1e10,
      1e-10,
      -0.0,
      -Math.PI/4,
      -Math.PI/2,
      -Math.PI,
      -2*Math.PI,
      -4*Math.PI,
      -100*Math.PI,
      -1e10,
      -1e-10,
    };

  /**
   * These values are the expected results, obtained from the RI.
   */
  private static double[] outputValues =
    {
      // output value         input value
      Double.NaN,             // NaN
      Double.NaN,             // Infinity
      Double.NaN,             // -Infinity
      0.004961954789184062,   // Double.MAX_VALUE
      4.9E-324,               // Double.MIN_VALUE
      0.0,                    // 0.0
      0.7071067811865475,     // Math.PI/4
      1.0,                    // Math.PI/2
      1.2246467991473532E-16, // Math.PI
      -2.4492935982947064E-16,// 2*Math.PI
      -4.898587196589413E-16, // 4*Math.PI
      1.964386723728472E-15,  // 100*Math.PI
      -0.4875060250875107,    // 1.0E10
      1.0E-10,                // 1.0E-10
      -0.0,                   // -0.0
      -0.7071067811865475,    // -Math.PI/4
      -1.0,                   // -Math.PI/2
      -1.2246467991473532E-16,// -Math.PI
      2.4492935982947064E-16, // -2*Math.PI
      4.898587196589413E-16,  // -4*Math.PI
      -1.964386723728472E-15, // -100*Math.PI
      0.4875060250875107,     // -1.0E10
      -1.0E-10,               // -1.0E-10
    };

  /**
    * These values represent various NaN
    */
  private static long[] NaNValues =
    {
      0x7fff800000000000L,
      0xffff800000000000L,
      0x7fff812345abcdefL,
      0xffff812345abcdefL,

      0x7fff000000000001L,
      0xffff000000000001L,
      0x7fff7654321fedcbL,
      0xffff7654321fedcbL
    };

  /**
   * Test not NaN values.
   */
  private void testInputValues(TestHarness harness)
  {
    double res;

    for (int i = 0; i < inputValues.length; ++i)
      {
	res = testedFunction(inputValues[i]);

	// exact equality
    if (Double.doubleToLongBits(res) != Double.doubleToLongBits(outputValues[i])) {
      harness.todo(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
    } else {
      harness.check(Double.doubleToLongBits(res), Double.doubleToLongBits(outputValues[i]));
    }
      }
  }

  /**
    * Entry point to a test.
    */
  public void test (TestHarness harness)
  {
    /*harness.check (new Double (Math.sin (1e50)).toString (),
		   "-0.4805001434937588");*/

    // Disabled until we can get it working on Mac.
     // testInputValues(harness);
  }
}
