import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g) {
        // On décide d'une couleur de fond pour notre rectangle
        g.setColor(Color.white);
        // On dessine celui-ci afin qu'il prenne tout la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // On redéfinit une couleur pour notre rond
        g.setColor(Color.red);
        // On le dessine aux coordonnées souhaitées
        g.fillOval(posX, posY, 50, 50);
    }

    /*
      *******************************************************************************************************
      Drawing functions
      *******************************************************************************************************
     */
    /**
     * Drawing the board only
     */
    private void drawBoard(){
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(5);

        for(int i=1;i<3;i++) {
            double x1 = (windowWidth / 3.) * i;
            graphicsContext.strokeLine(x1,0,x1,windowHeight);
        }

        for(int i=1;i<3;i++) {
            double y1 = (windowHeight / 3.) * i;
            graphicsContext.strokeLine(0,y1,windowWidth,y1);
        }


        refresh();
    }

    /**
     * Drawing current pieces on the board
     * @param board is the board
     */
    void drawPieces(int[] board){
        double x,y;
        double circleWidth = (windowWidth / 3.) / 2;
        double circleHeight = (windowHeight / 3.) / 2;
        double crossSize = (windowHeight / 3.) / 2;

        graphicsContext.setLineWidth(15);

        for(int i=0;i<9;i++){
            x = (i%3) * (windowWidth / 3.) - circleWidth/2 + ((windowWidth / 3.) / 2);
            y = (i/3) * (windowHeight / 3.) - circleHeight/2 + ((windowHeight / 3.) / 2);
            if(board[i] == 1)
                drawCircle(x,y,circleWidth,circleHeight);
            if(board[i] == 2){
                drawCross(x,y,crossSize);
            }
        }

        refresh();
    }

    /**
     * Drawing a circle at position (x,y) with a certain width and height
     * @param x position of the circle
     * @param y position of the circle
     * @param circleWidth  circle width
     * @param circleHeight circle height
     */
    private void drawCircle(double x, double y, double circleWidth, double circleHeight){
        graphicsContext.setStroke(Color.RED);
        graphicsContext.strokeOval(x,y,circleWidth,circleHeight);
    }

    /**
     * Drawing a cross at (x,y) with size corssSize
     * @param x position of the cross
     * @param y position of the cross
     * @param crossSize size of the cross
     */
    private void drawCross(double x, double y, double crossSize){
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.strokeLine(x,y,x+crossSize,y+crossSize);
        graphicsContext.strokeLine(x,y+crossSize,x+crossSize,y);
    }



    /**
     * Clear the current board and draw a clean board
     */
    void newGame(){
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0,0,windowWidth,windowHeight);
        drawBoard();
    }

    /**
     *
     * @return le numéro de la case en fonction des coordonnées
     */
    int getSquare(double x, double y){
        if(y < windowHeight/3) {
            if (x < windowWidth / 3)
                return 0;
            else if(x < windowWidth / 3 * 2)
                return 1;
            else
                return 2;
        }

        else if(y < windowHeight/3 * 2) {
            if (x < windowWidth / 3)
                return 3;
            else if(x < windowWidth / 3 * 2)
                return 4;
            else
                return 5;
        }

        else {
            if (x < windowWidth / 3)
                return 6;
            else if(x < windowWidth / 3 * 2)
                return 7;
            else
                return 8;
        }
    }

    /**
     *
     * @param square the chosen square
     * @param nbPlayer numero of the player
     * @return 0 if the move is correct, -1 otherwise
     */
    int chooseSquare(int square, int nbPlayer) {
        if(isPossible(square)){
            board[square] = nbPlayer;
            drawPieces(board);
            return 0;
        }
        return -1;
    }

    /**
     * Checking if there is nothing in the square square
     * @param square chosen square
     * @return true is possible, no otherwise
     */
    private boolean isPossible(int square){
        return board[square] == 0;
    }

    /**
     * Draw everything on the board
     */
    void refresh(){
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}