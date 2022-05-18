# Filtering Dark Images

### Method of evaluating how "dark" is the image

The simplest way is probably to check the brightness* or lightness* of every pixel, and make a decision based on computed values. 
However I am not entirely satisfied with this algorithm as many images might end up being removed for their dark background, while face may be perfectly visible.

(example)
![image](https://user-images.githubusercontent.com/53653426/168883036-cdf13391-7f84-49e6-abd2-de42f076d797.png)

I've played around using contrast (difference in lightness of brightest and darkest pixel) but to no avail either. There were photos with no contrast but still easily distinguishable as well as the other way around.

Next, I tried improving on initial method, not only calculating mean of lightness and brightness, but also median, to see the distribution of light and dark pixels.

Mean could be influenced by black or white areas of the image, median on the other hand is pretty stable, but unable to see extremes when there's high contrast.

Finally, I've decided to combine them in such a way, that mean is more important when image is really bright or really dark, and median in between.
This algorithm still has some issues with images like this (above) but without deep analysis of important parts of the image, it has pretty decent ratio of correctly assessed photos.

There is potential for improvement using more advanced statistical analysis of lightness, but probably I'd rather spend that time trying to improve some pictures to be viable to use.

*lightness - defined as "medium light" (mean of highest and lowest of RGB values)
*brightness - defined as luminance (maximum of R G and B)

### How to use this app

### Optimal Settings

Sorted values genereated on photos provided with the task using different functions to calculate scores

|        | linear | commonSteep | darkSteep |
|--------|:------:|:-----------:|:---------:|
| BRIGHT |   20   |      1      |     36    |
| BRIGHT |   23   |      1      |     38    |
| BRIGHT |   34   |      3      |     44    |
| BRIGHT |   43   |      5      |     47    |
| BRIGHT |   43   |      5      |     47    |
| BRIGHT |   44   |      5      |     48    |
| BRIGHT |   51   |      8      |     50    |
| BRIGHT |   51   |      8      |     50    |
| BRIGHT |   60   |      13     |     54    |
| BRIGHT |   60   |      13     |     54    |
| BRIGHT |   72   |      32     |     59    |
| BRIGHT |   72   |      30     |     59    |
| BRIGHT |   73   |      34     |     59    |
| BRIGHT |   75   |      39     |     60    |
|  DARK  |   89   |      85     |     72    |
|  DARK  |   94   |      94     |     81    |
|  DARK  |   95   |      95     |     83    |
|  DARK  |   96   |      96     |     85    |
|  DARK  |   98   |      98     |     92    |
|  DARK  |   98   |      98     |     93    |
|  DARK  |   98   |      99     |     94    |
|  DARK  |   99   |      99     |     96    |
|  DARK  |   99   |      99     |     97    |
|  DARK  |   99   |      99     |     98    |
|  DARK  |   99   |      99     |     98    |
|  DARK  |   99   |      99     |     98    |
|  DARK  |   99   |      99     |     98    |
|  DARK  |   99   |      99     |     98    |

I recommend using "commonSteep" function to achieve the biggest gap between accepted and discarded photos

|        | linear | commonSteep | darkSteep |
|--------|:------:|:-----------:|:---------:|
| BRIGHT |   75   |      39     |     60    |
|  DARK  |   89   |      85     |     72    |

Threshold for accepting photos should remain in those borders

### Photos Included

folder "input_photos" includes provided images and additional white and black png for testing purposes

### Possible Improvements
