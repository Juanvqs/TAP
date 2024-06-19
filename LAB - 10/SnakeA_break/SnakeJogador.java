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

class SnakeNode implements Comparable<SnakeNode>  {

    int x;
    int y;
    int g,h=0;
    private SnakeNode parent=null;
    
    
    public SnakeNode(int x, int y) {
        this.x=x;
        this.y=y;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }
    
    
    
    public int getG() {
        return g;
    }


    public void setG(int g) {
        this.g = g;
    }


    public int getH() {
        return h;
    }


    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return g+h;
    }

    public SnakeNode getParent() {
        return parent;
    }


    public void setParent(SnakeNode parent) {
        this.parent = parent;
    }

    public List<SnakeNode> myNeighbors(){

        SnakeNode up = new SnakeNode(getX()-1,getY());
        SnakeNode down = new SnakeNode(getX()+1, getY());
        SnakeNode left = new SnakeNode(getX(), getY()-1);
        SnakeNode right = new SnakeNode(getX(), getY()+1);

        
        List<SnakeNode> lis=new ArrayList<>();
        lis.add(up);
        lis.add(down);
        lis.add(left);
        lis.add(right);

        return lis;

    }

    public boolean equals(Object obj){

        if(this == obj) return true;

        if(obj instanceof SnakeNode){

            SnakeNode secondNode = (SnakeNode) obj;

            if(this.x == secondNode.x && this.y == secondNode.y){

                return true;
            }
        }
        return false;
    }

    public int compareTo(SnakeNode o) {

        int thisVal = this.getF();
        int otherVal = o.getF();
        
        int value = thisVal - otherVal;
        
        return (value > 0) ? 1 : (value < 0) ? - 1 : 0;
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
    public static Direction findShortestPath(boolean[][] grid, int cx, int cy, int mx, int my){

    //Tentando usar algoritmo para labirinto em um lugar não labirinto :(

    Queue<Node> l = new ArrayDeque<>();

    boolean[][] descobertos = new boolean[21][31];

    if(cy > 0 && cx > 0){

        descobertos[cy][cx] = true;
        l.add(new Node(cx, cy, null));
    }

    
    while (!l.isEmpty()){

        Node node = l.poll();

        for (Direction dir : Direction.values()) {

            if(node.x + dir.getDx() > 0 && node.x + dir.getDx() < 21  && node.y + dir.getDy() > 0 && node.y + dir.getDy() < 31){

                int newX = node.x + dir.getDx();
                int newY = node.y + dir.getDy();
                Direction newDir = node.initialDir == null ? dir : node.initialDir;

                if (newX == mx && newY == my) {

                    return newDir;
                }

                if (!grid[newY][newX] && !descobertos[newY][newX]) {

                    descobertos[newY][newX] = true;
                    l.add(new Node(newX, newY, newDir));
                }
            }
        }
    }

    Direction retorno = Direction.values()[4];

    return retorno;
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


    public int manhattan(SnakeNode source,SnakeNode destination){

        int xAbs=Math.abs(source.getX()-destination.getX());
        int yAbs=Math.abs(source.getY()-destination.getY());

        return xAbs+yAbs;
    }

    public LinkedList<SnakeNode> makePath(SnakeNode node){

        LinkedList<SnakeNode> path = new LinkedList<SnakeNode>();
        
        while(node.getParent() !=null){

            path.addFirst(node);
            node = node.getParent();
        }
                    
        return path;
    }

    public boolean isValid(SnakeNode n){
        
        if(n.getX()<0 || n.getY()<0){
            
            return false;
        }

        return jogo.isCelulaLivre(n.getX(),n.getY());
        
    }

    private LinkedList<SnakeNode> A_star(SnakeNode inicio, SnakeNode destino){

        PriorityQueue<SnakeNode> openl=new PriorityQueue<SnakeNode>();
    
        LinkedList<SnakeNode> closel = new LinkedList<SnakeNode>();

        inicio.setG(0);

        inicio.setH(manhattan(inicio,destino));
        
        inicio.setParent(null);

        openl.add(inicio);
        
        while(!openl.isEmpty()){
            
            //Menor F
            SnakeNode atual = (SnakeNode)openl.remove();

            //Alcançou?
            if(atual.equals(destino)){

                return makePath(atual);
            }
            
            //Checar cada vizinho e adicionar o custo de cada um deles
            List<SnakeNode> vizinhos = atual.myNeighbors();

            for(int i = 0; i < vizinhos.size(); i++){
                
                SnakeNode vizinho = vizinhos.get(i);
                
                boolean isInOpen = openl.contains(vizinho);
                boolean isInClosed = closel.contains(vizinho);
                
                int distVizi = atual.getG() + manhattan(atual, vizinho);
            
                if((!isInOpen && !isInClosed) || distVizi < vizinho.getG() ){

                    vizinho.setParent(atual); 
                    vizinho.setG(distVizi); 
                    vizinho.setH(manhattan(vizinho,destino));
                    
                    
                    if(isInClosed){

                        closel.remove(vizinho);
                    }

                    if(!isInOpen && isValid(vizinho)){

                        openl.add(vizinho);
                    }
                }
            }
            closel.add(atual);
        }
        
        //não foi dessa vez hermanito
        return null;
    }

    public SnakeNode dirLivreMov(){

        Point cabeca = jogo.getSegmentos().getFirst();

        SnakeNode neighbors = new SnakeNode(cabeca.x, cabeca.y);

        List<SnakeNode> list = neighbors.myNeighbors();

        for(int a=0; a<list.size();a++){

            SnakeNode node=list.get(a);
            
            if(isValid(node)){

                //Movimentar-se em uma direção livre
                return node;
            }
            
        }

        //moreu
        return null;
    }
    public char getDirecao() {

        Point cabeca = jogo.getSegmentos().getFirst();

        SnakeNode nova = new SnakeNode(cabeca.x,cabeca.y);
        SnakeNode comida = new SnakeNode(jogo.getComida().x,jogo.getComida().y);

        //Tentativa com A*
        LinkedList<SnakeNode> list = A_star(nova, comida);

        if(list != null){

                int x = list.getFirst().getX();
                int y = list.getFirst().getY();
                if(x - cabeca.x == 0 && y - cabeca.y == -1) return 'C';
                else if(x - cabeca.x == 1 && y - cabeca.y == 0) return 'D';
                else if(x - cabeca.x == 0 && y - cabeca.y == 1) return 'B';
                else if(x - cabeca.x == -1 && y - cabeca.y == 0) return 'E';
        }
        else{

            SnakeNode ok = dirLivreMov();
            
            if(ok != null){

                int x = ok.getX();
                int y = ok.getY();
                if(x - cabeca.x == 0 && y - cabeca.y == -1) return 'C';
                else if(x - cabeca.x == 1 && y - cabeca.y == 0) return 'D';
                else if(x - cabeca.x == 0 && y - cabeca.y == 1) return 'B';
                else if(x - cabeca.x == -1 && y - cabeca.y == 0) return 'E';
            }

            boolean grid[][] = new boolean[22][32];

            for (int i =0; i <=  21; i++) {

              for (int j = 0; j <= 31; j++) {

                  grid[i][j] = false;
              }
            }

            for (Point c : jogo.getSegmentos()) {

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

            //Tentativa com caminho mínimo em labirinto kkk
            Direction ans = findShortestPath(grid, cabeca.x, cabeca.y, jogo.getComida().x, jogo.getComida().y);

            if(ans.getDx() == 1 && ans.getDy() == 0) return 'D';
            else if(ans.getDx() == 0 && ans.getDy() == -1) return 'C';
            else if(ans.getDx() == 0 && ans.getDy() == 1) return 'B';
            else if(ans.getDx() == -1 && ans.getDy() == 0) return 'E';
            else{
                //Só nos resta morrer
                 if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y) && cabeca.x > jogo.getComida().x) {
                    return 'E';
                    }
                else if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y) && cabeca.x < jogo.getComida().x) {
                    return 'D';
                    }
                else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1) && cabeca.y > jogo.getComida().y) {
                    return 'C';
                    }
                else if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1) && cabeca.y < jogo.getComida().y) {
                    return 'B';
                    }
                
                 }
        
        }
    return 'E';
    }

}
    

