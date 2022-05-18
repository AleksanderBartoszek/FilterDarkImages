
/** Functions with different properties to determine whether image is too dark
 *
 *  I recommend using "commonSteep" for most cases
 *  as it's values best differentiate between normal images and those a little too dark
 *
 *  Use Dark step when it is necessary to differentiate really dark images
 *
 *  Use linear for fastest computing
 */

def linear(x: Double): Int = {
  val out = -(0.5 * x - 0.5) * 100
  out.toInt
}

def commonSteep(x: Double): Int = {
  val out = (0.3917 * (Math.atan(-5 * x - 3) + Math.atan(8))) * 100
  out.toInt
}

def darkSteep(x: Double): Int = {
  val out = (-0.139 * (Math.tan(1.3 * x) - Math.tan(1.3))) * 100
  out.toInt
}

/** Function evaluating score how light or dark is picture
 *
 * can be called with brightness instead, output is similar,
 * I haven't tested exactly which is better but lightness seems logical
 * @param function function to calculate score with
 * @param mean mean of lightness on the picture
 * @param median median of lightness on the picture
 * @return score in range <0,100> where white is 0, black is 100
 */
def score(function: Double => Int, mean: Double, median: Double): Int = {
  val weight = ((mean - (255/2.0)) / 255) * ((mean - (255/2.0)) / 255)
  val combined = (mean * weight) + (median * (1 - weight))
  val x = (combined - (255/2.0)) / (255/2.0)
  function(x)
}