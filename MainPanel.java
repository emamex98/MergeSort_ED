import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainPanel extends JPanel implements ActionListener{

  JTextField tfNumElementos;
  JTextArea  tfUnsorted, tfSorted;
  JButton btGo;
  JScrollPane scrollPane1, scrollPane2;
  JLabel runtime;

  int[] arrNumbers;

  public MainPanel(){
    super();

     this.setPreferredSize(new Dimension(500,600));
     //this.setBackground(Color.BLACK);

     this.add(new JLabel("<html><center><br><b>Ruleta 1<br>Emanuel Estrada Larios<br>Merge Sort</b><br><br>Este programa crea un arreglo de numeros enteros aleatorios en el rango de<br>1-100 y los ordena utilizando la t&eacute;cnica 'merge sort'.<br><br>Ingrese el n&uacute;mero de elementos a crear:<br></center></html>"));

     this.tfNumElementos = new JTextField(15);
     this.add(this.tfNumElementos);

     this.btGo = new JButton("Generar y Ordenar");
     this.btGo.addActionListener(this);
     this.add(this.btGo);

     this.tfUnsorted = new JTextArea(10,35);
     this.tfUnsorted.setLineWrap(true);
     this.tfSorted = new JTextArea(10,35);
     this.tfSorted.setLineWrap(true);

     this.scrollPane1 = new JScrollPane(this.tfUnsorted);
     this.add(this.scrollPane1);
     this.scrollPane2 = new JScrollPane(this.tfSorted);
     this.add(this.scrollPane2);

     this.runtime = new JLabel();
     this.add(this.runtime);


  }

  public void actionPerformed(ActionEvent e){

    this.tfUnsorted.setText("");
    this.tfSorted.setText("");

    if (e.getSource() == btGo) {
      arrNumbers = new int[Integer.parseInt(this.tfNumElementos.getText())];

      for(int i=0; i<arrNumbers.length; i++) {
        arrNumbers[i] = (int)(Math.random()*100 + 1);
        this.tfUnsorted.append(arrNumbers[i] + ", ");
      }

      Merge m = new Merge();
      this.arrNumbers = m.mergeSort(this.arrNumbers).clone();

      for(int i=0; i<arrNumbers.length; i++) {
        this.tfSorted.append(arrNumbers[i] + ", ");
      }

      this.runtime.setText("Runtime: " + m.getRuntime() + " segundos.");
      this.revalidate();

    }
  }

}
