/// This poster generator is created by Ecenur Yavuz with the inspiration of Josef M�ller-Brockmann's Grid Systems.
/// It can create 2 different grid layouts. - standart and gradient-
/// Photos can be filtered with 3 options except using originals. -gray-negative-pen-
/// Filter options are defined as methods in picture class,so to be able to use them, picture class should be runned.
/// As headline's font, Helvetica is used.
/// If canvas size changes proportionate to 565x792pixels, postergenerator still gives fine results. Otherwise photos might be distorted. 

import java.awt.*;
import java.awt.Color;
import java.util.Scanner;
import java.awt.font.*;
import java.text.*;
import java.awt.image.BufferedImage;
import java.lang.Object;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;

public class PosterGenerator {
    public static void main(String[] args) {

        ////// CREATING THE CANVAS 565x792pixels //////

        Picture PictureCanvas = new Picture(565, 792);

        System.out.println("please enter the bleed (for the best result, bleed is 25)");
        Scanner keyboard1 = new Scanner(System.in);
        int bleed = keyboard1.nextInt();

        System.out.println("please enter the margin (for the best result, margin is 10)");
        Scanner keyboard2 = new Scanner(System.in);
        int margin = keyboard2.nextInt();

        int activeCanvasWidth = PictureCanvas.getWidth() - 2 * (bleed);
        int activeCanvasHeight = PictureCanvas.getHeight() - 2 * (bleed);
        int recWidth = (activeCanvasWidth - (4 * margin)) / 5;
        int recHeight = (activeCanvasHeight - (7 * margin)) / 8;

        ////// SELECTING THE FILTERS AND GRID LAYOUTS //////

        System.out.println("please select your filter and type only its number 1-Make Grayscale, 2-Make Negative 3-Make penstyle 4-Use original ");
        Scanner keyboard3 = new Scanner(System.in);
        int a = keyboard3.nextInt();

        System.out.println("please type 1 to use gradient grid system and type 2 to use standart grid system ");
        Scanner keyboard4 = new Scanner(System.in);
        int b = keyboard4.nextInt();


        ////// SELECTING THE PICTURES //////

        // mavi boneli kadin fotosu//
        System.out.println("please select the first picture named mavibonelikadin");
        String fileName1 = FileChooser.pickAFile();
        Picture sourcePict1 = new Picture(fileName1);

        // dua eden adam fotosu //
        System.out.println("please select the second picture named duaedenadam");
        String fileName2 = FileChooser.pickAFile();
        Picture sourcePict2 = new Picture(fileName2);

        // kirmizi oda foto //
        System.out.println("please select the third picture named kirmizioda");
        String fileName3 = FileChooser.pickAFile();
        Picture sourcePict3 = new Picture(fileName3);

        // sarimsi foto //
        System.out.println("please select the fourth picture named sarimsi");
        String fileName4 = FileChooser.pickAFile();
        Picture sourcePict4 = new Picture(fileName4);

        // bulutyesil foto //
        System.out.println("please select the fifth picture named bulutyesil");
        String fileName5 = FileChooser.pickAFile();
        Picture sourcePict5 = new Picture(fileName5);

        // pembekemer foto //
        System.out.println("please select the sixth picture named pembekemer");
        String fileName6 = FileChooser.pickAFile();
        Picture sourcePict6 = new Picture(fileName6);

        // ayak foto //
        System.out.println("please select the seventh picture named ayak");
        String fileName7 = FileChooser.pickAFile();
        Picture sourcePict7 = new Picture(fileName7);

        // koltuk foto //
        System.out.println("please select the eighth picture named koltuk");
        String fileName8 = FileChooser.pickAFile();
        Picture sourcePict8 = new Picture(fileName8);


        if (a == 1) {
            sourcePict1.grayscale();
            sourcePict2.grayscale();
            sourcePict3.grayscale();
            sourcePict4.grayscale();
            sourcePict5.grayscale();
            sourcePict6.grayscale();
            sourcePict7.grayscale();
            sourcePict8.grayscale();
        } else if (a == 2) {
            sourcePict1.negate();
            sourcePict2.negate();
            sourcePict3.negate();
            sourcePict4.negate();
            sourcePict5.negate();
            sourcePict6.negate();
            sourcePict7.negate();
            sourcePict8.negate();
        } else if (a == 3) {
            sourcePict1.edgeDetection(0.8);
            sourcePict2.edgeDetection(0.8);
            sourcePict3.edgeDetection(0.8);
            sourcePict4.edgeDetection(0.8);
            sourcePict5.edgeDetection(0.8);
            sourcePict6.edgeDetection(0.8);
            sourcePict7.edgeDetection(0.8);
            sourcePict8.edgeDetection(0.8);
        } else {
        }

        ////// THE PICTURES TURN INTO 2D GRAPHICS //////

        Graphics p1 = PictureCanvas.getGraphics();
        Graphics p11 = (Graphics2D) p1;

        Graphics p2 = PictureCanvas.getGraphics();
        Graphics p22 = (Graphics2D) p2;

        Graphics p3 = PictureCanvas.getGraphics();
        Graphics p33 = (Graphics2D) p3;

        Graphics p4 = PictureCanvas.getGraphics();
        Graphics p44 = (Graphics2D) p4;

        Graphics p5 = PictureCanvas.getGraphics();
        Graphics p55 = (Graphics2D) p5;

        Graphics p6 = PictureCanvas.getGraphics();
        Graphics p66 = (Graphics2D) p6;

        Graphics p7 = PictureCanvas.getGraphics();
        Graphics p77 = (Graphics2D) p7;

        Graphics p8 = PictureCanvas.getGraphics();
        Graphics p88 = (Graphics2D) p8;


        ////// GRADIENT GRID LAYOUT //////

        if (b == 1) {


            // first 3 row rectangles//

            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = bleed; y < (3 * recHeight + 2 * margin + 1); y = y + (recHeight + margin)) {

                    Rectangle2D.Double rectangle1 = new Rectangle2D.Double(x, y, recWidth, recHeight);

                    p66.setClip(rectangle1);
                    p66.drawImage(sourcePict6.getImage(), (3 * recWidth + 3 * margin + bleed), (bleed), (2 * recWidth + margin), (recHeight), null);

                    p55.setClip(rectangle1);
                    p55.drawImage(sourcePict5.getImage(), (2 * recWidth + 2 * margin + bleed), (bleed), (recWidth), (recHeight), null);

                    p22.setClip(rectangle1);
                    p22.drawImage(sourcePict2.getImage(), (2 * recWidth + 2 * margin + bleed), (recHeight + bleed + margin), (3 * recWidth + 2 * margin), (4 * recHeight + 3 * margin), null);

                    p11.setClip(rectangle1);
                    p11.drawImage(sourcePict1.getImage(), bleed, bleed, (2 * recWidth + margin), (3 * recHeight + 2 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, recHeight);
                }
            }


            // 4.row rectangles//
            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = 3 * recHeight + 3 * margin + bleed; y < (4 * recHeight + 3 * margin + bleed); y = y + (recHeight + margin)) {

                    Rectangle2D.Double rectangle4 = new Rectangle2D.Double(x, y, recWidth, 5 * recHeight / 6);
                    p88.setClip(rectangle4);
                    p88.drawImage(sourcePict8.getImage(), (recWidth + margin + bleed), (3 * recHeight + 3 * margin + bleed), (recWidth), (recHeight), null);

                    p77.setClip(rectangle4);
                    p77.drawImage(sourcePict7.getImage(), (bleed), (3 * recHeight + 3 * margin + bleed), (recWidth), (recHeight), null);

                    p22.setClip(rectangle4);
                    p22.drawImage(sourcePict2.getImage(), (2 * recWidth + 2 * margin + bleed), (recHeight + bleed + margin), (3 * recWidth + 2 * margin), (4 * recHeight + 3 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, 5 * recHeight / 6);

                }
            }


            // 5.row rectangles//
            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = 4 * recHeight + 4 * margin + bleed; y < (5 * recHeight + 4 * margin + bleed); y = y + (recHeight + margin)) {
                    if (b == 1) {
                        Rectangle2D.Double rectangle5 = new Rectangle2D.Double(x, y, recWidth, recHeight);
                    } else {
                    }

                    Rectangle2D.Double rectangle5 = new Rectangle2D.Double(x, y, recWidth, 4 * recHeight / 6);

                    p44.setClip(rectangle5);
                    p44.drawImage(sourcePict4.getImage(), (bleed), (4 * recHeight + 4 * margin + bleed), (2 * recWidth + margin), (4 * recHeight + 3 * margin), null);

                    p22.setClip(rectangle5);
                    p22.drawImage(sourcePict2.getImage(), (2 * recWidth + 2 * margin + bleed), (recHeight + bleed + margin), (3 * recWidth + 2 * margin), (4 * recHeight + 3 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, 4 * recHeight / 6);
                }
            }


            // 6.row rectangles//
            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = 5 * recHeight + 5 * margin + bleed; y < (6 * recHeight + 5 * margin + bleed); y = y + (recHeight + margin)) {
                    if (b == 1) {
                        Rectangle2D.Double rectangle6 = new Rectangle2D.Double(x, y, recWidth, recHeight);
                    } else {
                    }

                    Rectangle2D.Double rectangle6 = new Rectangle2D.Double(x, y, recWidth, 3 * recHeight / 6);

                    p44.setClip(rectangle6);
                    p44.drawImage(sourcePict4.getImage(), (bleed), (4 * recHeight + 4 * margin + bleed), (2 * recWidth + margin), (4 * recHeight + 3 * margin), null);

                    p33.setClip(rectangle6);
                    p33.drawImage(sourcePict3.getImage(), (2 * recWidth + bleed + 2 * margin), (5 * recHeight + 5 * margin + bleed), (3 * recWidth + 2 * margin), (3 * recHeight + 2 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, 3 * recHeight / 6);
                }
            }


            // 7.row rectangles//
            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = 6 * recHeight + 6 * margin + bleed; y < (7 * recHeight + 6 * margin + bleed); y = y + (recHeight + margin)) {
                    if (b == 1) {
                        Rectangle2D.Double rectangle7 = new Rectangle2D.Double(x, y, recWidth, recHeight);
                    } else {
                    }

                    Rectangle2D.Double rectangle7 = new Rectangle2D.Double(x, y, recWidth, 2 * recHeight / 6);

                    p44.setClip(rectangle7);
                    p44.drawImage(sourcePict4.getImage(), (bleed), (4 * recHeight + 4 * margin + bleed), (2 * recWidth + margin), (4 * recHeight + 3 * margin), null);

                    p33.setClip(rectangle7);
                    p33.drawImage(sourcePict3.getImage(), (2 * recWidth + bleed + 2 * margin), (5 * recHeight + 5 * margin + bleed), (3 * recWidth + 2 * margin), (3 * recHeight + 2 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, 2 * recHeight / 6);
                }
            }


            // 8.row rectangles//
            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = 7 * recHeight + 7 * margin + bleed; y < (8 * recHeight + 7 * margin + bleed); y = y + (recHeight + margin)) {
                    if (b == 1) {
                        Rectangle2D.Double rectangle8 = new Rectangle2D.Double(x, y, recWidth, recHeight);
                    } else {
                    }

                    Rectangle2D.Double rectangle8 = new Rectangle2D.Double(x, y, recWidth, recHeight / 6);

                    p44.setClip(rectangle8);
                    p44.drawImage(sourcePict4.getImage(), (bleed), (4 * recHeight + 4 * margin + bleed), (2 * recWidth + margin), (4 * recHeight + 3 * margin), null);

                    p33.setClip(rectangle8);
                    p33.drawImage(sourcePict3.getImage(), (2 * recWidth + bleed + 2 * margin), (5 * recHeight + 5 * margin + bleed), (3 * recWidth + 2 * margin), (3 * recHeight + 2 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, recHeight / 6);
                }
            }

        }


        ////// STANDART GRID LAYOUT //////

        else if (b == 2) {

            for (int x = bleed; x < (activeCanvasWidth - recWidth + bleed + 1); x = x + (recWidth + margin)) {
                for (int y = bleed; y < (8 * recHeight + 7 * margin + bleed + 1); y = y + (recHeight + margin)) {

                    Rectangle2D.Double rectangle9 = new Rectangle2D.Double(x, y, recWidth, recHeight);

                    p88.setClip(rectangle9);
                    p88.drawImage(sourcePict8.getImage(), (recWidth + margin + bleed), (3 * recHeight + 3 * margin + bleed), (recWidth), (recHeight), null);

                    p77.setClip(rectangle9);
                    p77.drawImage(sourcePict7.getImage(), (bleed), (3 * recHeight + 3 * margin + bleed), (recWidth), (recHeight), null);

                    p66.setClip(rectangle9);
                    p66.drawImage(sourcePict6.getImage(), (3 * recWidth + 3 * margin + bleed), (bleed), (2 * recWidth + margin), (recHeight), null);

                    p55.setClip(rectangle9);
                    p55.drawImage(sourcePict5.getImage(), (2 * recWidth + 2 * margin + bleed), (bleed), (recWidth), (recHeight), null);

                    p44.setClip(rectangle9);
                    p44.drawImage(sourcePict4.getImage(), (bleed), (4 * recHeight + 4 * margin + bleed), (2 * recWidth + margin), (4 * recHeight + 3 * margin), null);

                    p33.setClip(rectangle9);
                    p33.drawImage(sourcePict3.getImage(), (2 * recWidth + bleed + 2 * margin), (5 * recHeight + 5 * margin + bleed), (3 * recWidth + 2 * margin), (3 * recHeight + 2 * margin), null);

                    p22.setClip(rectangle9);
                    p22.drawImage(sourcePict2.getImage(), (2 * recWidth + 2 * margin + bleed), (recHeight + bleed + margin), (3 * recWidth + 2 * margin), (4 * recHeight + 3 * margin), null);

                    p11.setClip(rectangle9);
                    p11.drawImage(sourcePict1.getImage(), bleed, bleed, (2 * recWidth + margin), (3 * recHeight + 2 * margin), null);

                    Graphics Graphic = PictureCanvas.getGraphics();
                    Graphic.setColor(Color.black);
                    Graphic.drawRect(x, y, recWidth, recHeight);

                }
            }

        }


        ////// THE HEADLINES //////

        Graphics Graphic3 = PictureCanvas.getGraphics();
        Graphic3.setColor(Color.black);
        Graphic3.setFont(new Font("Helvetica", Font.BOLD, 25));
        Graphic3.drawString("Josef M�ller - Brockman", (2 * recWidth) + (2 * margin) + bleed, PictureCanvas.getHeight() - bleed);

        Graphics Graphic4 = PictureCanvas.getGraphics();
        Graphic4.setColor(Color.black);
        Graphic4.setFont(new Font("Helvetica", Font.BOLD, 25));
        Graphic4.drawString("Grid System", bleed, PictureCanvas.getHeight() - bleed);


////// AND POSTER IS READY TO SAVE //////      

        System.out.println("Hey, Your poster is ready ! ");
        System.out.println("please select where your poster to be saved, and dont forget to write file type (ex: poster.jpg");

        PictureCanvas.show();
        PictureCanvas.write(FileChooser.pickAFile());

    }
}

////// the end //////       