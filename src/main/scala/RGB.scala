/** Class for storing important information about pixel
 * 
 * @param r red <0;255>
 * @param g green <0;255>
 * @param b blue <0;255
 */
class RGB (r: Int, g: Int, b: Int) {
  /** functions returning maximal and minimal value of R G and B */
  def max(): Int = { Math.max(r, Math.max(g, b)) }
  def min(): Int = { Math.min(r, Math.min(g, b)) }
}
