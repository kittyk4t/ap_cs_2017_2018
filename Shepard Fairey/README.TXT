Shepard Fairey Lab

****LINK TO REFLECTION:****
https://drive.google.com/a/naperville203.org/file/d/15hh1STND-NkQAuKbruyWNcm8ZPw16df0/view?usp=sharing

# Introduction
# 
A lot of colors combine to form an image, whereas the Shepard Fairey
	uses only four. Fairey's collage groups portrait contains only
	off-white, red and two shades of blue. Fairey's collage groups
	large regions with a single color. The trick is determining which
	pixels to group. The darkest sections of the portrait use the
	darkest hue of Fairey's four color palette. We really only need
	to measure a pixel's intensity rather than its actual color. A
	pixel colored (255,0,0) could be viewed as having the same
	intensity as a pixel visualizing (0,255,0).

So in hope of "Fairey-fication" let's convert the image to grayscale
	by computing the average of each pixel's red, green, and blue
	values. If pixel is colored (r, g, b), then we replace this with
	the single value (r + g + b)/ 3 = gray value. Grayscale contains
	only one color channel ranging from black (value of 0) to white
	(value of 255).

# Requirements
# 
## Background Preparation
## 
1. familiarize yourself with the Picture, Pixel, and Color classes by
	reading the documentation

2. review the maxBlue method in the ColorManipulator class

3. implement the maxRed and maxGreen methods in the ColorManipulator
	class

4. implement the adjustRed, adjustBlue, and adjustGreen methods in
	the ColorManipulator class

    1. public void adjustRed( double factor ) // multiply the color
    	by the factor

5. review the negate method in the ColorManipulator class

6. implement the lighten and darken methods in the ColorManipulator
	class

    2. use the lighten and darken methods of the Color class

7. implement the grayscale method in the ColorManipulator class

8. implement a JUnit test for the grayscale method

## Shepard-fying Algorithm
## 
1. take a selfie

2. convert your selfie picture to grayscale

3. find the smallest and largest grayscale values in the picture

4. divide the range between the smallest and largest into four equal
	subranges

5. convert the color of each pixel in the picture to one of the four
	colors (dark blue, red, light blue, off-white) associated with
	each subrange

Each step of the algorithm should be a separate method in the
	ShepardFairey class.

# Extensions:
# 
* Choose your own 4 color palette and convert your picture. This
	[site](http://paletton.com/#uid=71T1p0kllll1FEsbvsfvberW17x) may
	help you choose a different 4 color pallet.

* Add more awesome.

# Submission:
# 
* Submit a link to your GitHub repository with this assignment.

# Credit:
# 
* This lab is adapted from Mr. Hayes’s lab at NCHS.

* He adapted it from Tim Chartier’s "Math Bytes"



https://docs.google.com/document/d/1YI88PIB4hJaGN4JobcRVGck0Jbo9-lNFWAD8GHpABvo/edit#