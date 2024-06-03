/* Este programa deve alternar entre exibir três cartões inicialmente de cor cinza. Conforme o desejo do usuário, ele deve poder alterar a cor do cartão atualmente exibido para verde, azul ou vermelho */

import java.awt.*;
import java.awt.event.*;

public class ProgramaCardLayout2 extends Frame implements ActionListener{
    Button verde, azul, vermelho, proximo, anterior;
    CardLayout cardLayout;
    GridLayout gridLayout;
    Panel painelCartoes, painelBotoes, painelProximoAnterior;
    public int currentCard = 1;
    Panel cartao1, cartao2, cartao3;

    public ProgramaCardLayout2() {
        setTitle("Programa para testar o Card Layout II");
        setSize(300, 500);
        setLayout(new BorderLayout());
        setVisible(true);

        cardLayout = new CardLayout();
        painelCartoes = new Panel();
        painelCartoes.setLayout(cardLayout);

        gridLayout = new GridLayout();
        painelBotoes = new Panel();
        painelBotoes.setLayout(gridLayout);

        painelProximoAnterior = new Panel();
        painelProximoAnterior.setLayout(gridLayout);

        add(painelBotoes, BorderLayout.NORTH);
        add(painelCartoes, BorderLayout.CENTER);
        add(painelProximoAnterior, BorderLayout.SOUTH);

        cartao1 = new Panel();
        cartao1.setBackground(Color.GRAY);
        painelCartoes.add(cartao1, "Cartão 1");

        cartao2 = new Panel();
        cartao2.setBackground(Color.GRAY);
        painelCartoes.add(cartao2, "Cartão 2");

        cartao3 = new Panel();
        cartao3.setBackground(Color.GRAY);
        painelCartoes.add(cartao3, "Cartão 3");

        verde = new Button("Verde");
        painelBotoes.add(verde);
        verde.addActionListener(this);
        azul = new Button("Azul");
        painelBotoes.add(azul);
        azul.addActionListener(this);
        vermelho = new Button("Vermelho");
        painelBotoes.add(vermelho);
        vermelho.addActionListener(this);

        anterior = new Button("Anterior");
        painelProximoAnterior.add(anterior);
        anterior.addActionListener(this);
        proximo = new Button("Próximo");
        painelProximoAnterior.add(proximo);
        proximo.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proximo) {
            cardLayout.next(painelCartoes);
            currentCard++;
            if (currentCard == 4) currentCard = 1;
        }
        if (e.getSource() == anterior) {
            cardLayout.previous(painelCartoes);
            currentCard--;
            if (currentCard == 0) currentCard = 3;
        }
        if (e.getSource() == verde) {
            switch(currentCard) {
                case 1:
                    cartao1.setBackground(Color.GREEN);
                    break;
                case 2:
                    cartao2.setBackground(Color.GREEN);
                    break;
                case 3:
                    cartao3.setBackground(Color.GREEN);
                    break;
            }
        }
        if (e.getSource() == azul) {
            switch(currentCard) {
                case 1:
                    cartao1.setBackground(Color.BLUE);
                    break;
                case 2:
                    cartao2.setBackground(Color.BLUE);
                    break;
                case 3:
                    cartao3.setBackground(Color.BLUE);
                    break;
            }
        }
        if (e.getSource() == vermelho) {
            switch(currentCard) {
                case 1:
                    cartao1.setBackground(Color.RED);
                    break;
                case 2:
                    cartao2.setBackground(Color.RED);
                    break;
                case 3:
                    cartao3.setBackground(Color.RED);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new ProgramaCardLayout2();
    }
}
