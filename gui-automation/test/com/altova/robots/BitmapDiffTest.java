package com.altova.robots;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class BitmapDiffTest extends BitmapDiff {

	@Override
	public BufferedImage diffMarks() {
		BufferedImage myimage=ImageUtils.readIcon("debug_findHighlight.png");
		return myimage;
	}
	
     @Test
	public void TestDiffBoundsSelection(){
		Rectangle r = diffBoundsSelection();
		System.out.println(r);
	}
}
