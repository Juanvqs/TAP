import java.awt.Point;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Classe de exemplo para a implementação de um Jogador para o Jogo Snake.
 * Nesta implementação, a próxima direção da cobra é escolhida aleatoriamente
 * entre as direções possíveis (que não geram colisões).
 * <p>
 * Use esta classe como base inicial para a sua solução do jogo. Basicamente
 * você precisará reimplementar o método {@code getDirecao}.
 * 
 * @author Horácio
 */



enum Direction {
  UP(0, -1),
  RIGHT(1, 0),
  DOWN(0, 1),
  LEFT(-1, 0),
  NOFF(0,0);

  private final int dx;
  private final int dy;

  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  public int getDx() {
    return dx;
  }

  public int getDy() {
    return dy;
  }
}

public class SnakeJogador {
    private Snake jogo;
    
    /**
     * Cria um novo jogador para o jogo passado como parâmetro.
     * @param jogo jogo snake.
     */
    public SnakeJogador(Snake jogo) {
        this.jogo = jogo;
    }

    public boolean isCelulaLivre(int x,  int y) {
        // Verifica se colidiu com as bordas da arena
        if (x < 0 || x >= jogo.getLargura() || y < 0 || y >= jogo.getAltura()) return false;
    
        // Verifica se colidiu com a cobra
        for (Point segmentoAtual : jogo.getSegmentos())
            if (segmentoAtual.x == x && segmentoAtual.y == y) return false;
        
        return true;
    }
    /**
     * Executado pelo método {@link Snake#inicia()} a cada 'tick' do jogo para
     * perguntar qual a próxima direção da cobra ('C'ima, 'D'ireita, 'B'aixo,
     * 'E'squerda ou 'N'enhum).
     * 
     * @return a próxima direção da cobra.
     */
    public static Direction findShortestPath(boolean[][] lab, int cx, int cy, int mx, int my) {

    Queue<Node> queue = new ArrayDeque<>();

    boolean[][] discovered = new boolean[21][31];

    if(cy > 0 && cx > 0){
        discovered[cy][cx] = true;
        queue.add(new Node(cx, cy, null));
    }

    
    while (!queue.isEmpty()){

      Node node = queue.poll();

      for (Direction dir : Direction.values()) {

        if(node.x + dir.getDx() > 0 && node.x + dir.getDx() < 21  && node.y + dir.getDy() > 0 && node.y + dir.getDy() < 31){
        int newX = node.x + dir.getDx();
        int newY = node.y + dir.getDy();
        Direction newDir = node.initialDir == null ? dir : node.initialDir;

        if (newX == mx && newY == my) {
          return newDir;
        }

        if (!lab[newY][newX] && !discovered[newY][newX]) {

          discovered[newY][newX] = true;
          queue.add(new Node(newX, newY, newDir));
        }
      }
    }
}
    Direction hh= Direction.values()[4];
    return hh;
  }

  private static class Node {
    final int x;
    final int y;
    final Direction initialDir;

    public Node(int x, int y, Direction initialDir) {
      this.x = x;
      this.y = y;
      this.initialDir = initialDir;
  }
}
  /*public static void main(String[] args) {
      
    boolean grid[][] = new boolean[6][6];

    for (int i =1; i <= 5; i ++) {
      for (int j = 1; j <= 5; j ++ ) {

          grid[i][j] = false;
        
      }
      
    }
    grid[2][2] = true;
    grid[3][2] = true;
    grid[4][2] = true;
    System.out.println(findShortestPathToMouse(grid,1,1,4,4));
     for (int i =1; i <= 5; i ++) {
      for (int j = 1; j <= 5 ; j ++ ) {

          System.out.print(grid[i][j]);
          System.out.print('|');
        
      }
      System.out.println();
      
    }
}*/

    public char getDirecao() {
        /*
         * IMPLEMENTE AQUI A SUA SOLUÇÃO PARA O JOGO
         */

        boolean grid[][] = new boolean[22][32];

    for (int i =0; i <=  21; i++) {
      for (int j = 0; j <= 31; j++) {

          grid[i][j] = false;
        
      }
      
    }
    for (Point c : jogo.getSegmentos()) {
        //System.out.printf("%d %d\n", c.x,c.y);
        grid[c.y][c.x] = true;
        
    }
    for (int h = 0; h <= jogo.getLargura()+1; h++){
        grid[0][h] = true;
        grid[21][h] = true;        
    }
    for (int h = 0; h <= jogo.getAltura()+1; h++){
        grid[h][0] = true;
        grid[h][31] = true;
    }
   grid[jogo.getComida().y][jogo.getComida().x] = false;

    /*for (int l =0; l <= 21; l ++) {
      for (int k = 0; k <= 31 ; k ++ ) {

          System.out.printf("%d", grid[l][k] == false ? 0 : 1);
        
      }
      System.out.println();
  }*/
    Point cabeca = jogo.getSegmentos().getFirst();

    //System.out.println(findShortestPathToMouse(grid,cabeca.x-1,cabeca.y-1,jogo.getComida().x,jogo.getComida().y));

    Direction ans = findShortestPath(grid,cabeca.x,cabeca.y,jogo.getComida().x,jogo.getComida().y);
    if(ans.getDx() == 1 && ans.getDy() == 0) return 'D';
    else if(ans.getDx() == 0 && ans.getDy() == -1) return 'C';
    else if(ans.getDx() == 0 && ans.getDy() == 1) return 'B';
    else if(ans.getDx() == -1 && ans.getDy() == 0) return 'E';
    else{
         if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y) && cabeca.x > jogo.getComida().x) {
               // possiveisDirecoes.add('E');
            return 'E';
            }
        else if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y) && cabeca.x < jogo.getComida().x) {
                //possiveisDirecoes.add('D');
            return 'D';
            }
        else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1) && cabeca.y > jogo.getComida().y) {
                //possiveisDirecoes.add('C'); 
            return 'C';
            }
        else if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1) && cabeca.y < jogo.getComida().y) {
                //possiveisDirecoes.add('B');
            return 'B';
            }
        else{
            for (Point segmentoAtual : jogo.getSegmentos()){
                if (segmentoAtual.x == cabeca.x+1 && segmentoAtual.y == cabeca.y+1){
                    System.out.println("situacao 1");

                    
                    if(jogo.getDirecaoAtual() == 'D') return 'C';
                    else if (jogo.getDirecaoAtual() == 'E') return 'B';
                    
                }
                else if(segmentoAtual.x == cabeca.x+1 && segmentoAtual.y == cabeca.y+1){
                    //System.out.println("corpo em cima vai pra esq");
                    System.out.println("situacao 2");
                    return 'C';
                }
                else if(segmentoAtual.x == cabeca.x+1 && segmentoAtual.y == cabeca.y+1){
                    System.out.println("situacao 3");
                    if(jogo.getDirecaoAtual() == 'C') return 'C';
                    else if (jogo.getDirecaoAtual() == 'B') return 'B';
                }
                else if(segmentoAtual.x == cabeca.x+1 && segmentoAtual.y == cabeca.y+1){
                    System.out.println("situacao 4");
                    if(jogo.getDirecaoAtual() == 'C') return 'C';
                    else if (jogo.getDirecaoAtual() == 'B') return 'D';
                }
                else{
                    
                }
            }
        }


    }
     /*for (int i =1; i <= 20; i ++) {
      for (int j = 1; j <= 20 ; j ++ ) {

          System.out.print(grid[i][j]);
          System.out.print('|');
        
      }

      System.out.println();
      
    }





















        /*System.out.println(jogo.getLarguraPixels());
        System.out.println(jogo.getLarguraPixels());
        System.out.println(jogo.getComida().getX());
        System.out.println("cabeca x = " + jogo.getSegmentos().getFirst().x);
        System.out.println("cabeca y = " + jogo.getSegmentos().getFirst().y);
        System.out.println("Comida x = " + jogo.getComida().x);
        System.out.println("comida y = " + jogo.getComida().y);*/

        /*if(cim == true) System.out.println("tem corpo pra cima");
        if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y) && cabeca.x > jogo.getComida().x) {
                possiveisDirecoes.add('E');
            }
        else if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y) && cabeca.x < jogo.getComida().x) {
                possiveisDirecoes.add('D');
            }
        else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1) && cabeca.y > jogo.getComida().y) {
                possiveisDirecoes.add('C'); 
            }
        else if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1) && cabeca.y < jogo.getComida().y) {
                possiveisDirecoes.add('B');
            }
        
        // Não existe mais nenhuma direção disponível
        if (possiveisDirecoes.size() == 0){
                
            for (Point segmentoAtual : jogo.getSegmentos()){
                if (segmentoAtual.x == cabeca.x-1 && segmentoAtual.y == cabeca.y){
                    System.out.println("corpo em cima vai pra dir");
                    return 'E';
                }
                else if(segmentoAtual.x == cabeca.x+1 && segmentoAtual.y == cabeca.y){
                    System.out.println("corpo em cima vai pra esq");
                    return 'C';
                }
                else if(segmentoAtual.x == cabeca.x && segmentoAtual.y == cabeca.y+1){
                    System.out.println("corpo em baixo vai pra esq");
                    return 'E';
                }
                else if(segmentoAtual.x == cabeca.x && segmentoAtual.y == cabeca.y-1){
                    System.out.println("corpo em cima vai pra dir");
                    return 'E';
                }
            }
        }*/
        

//return possiveisDirecoes.get(0);
        return 'E';
    }
    

}
