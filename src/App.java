import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class App extends JFrame {

    SocialNetwork sn = new SocialNetwork();
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panel1;
    private JButton ingresarButton;
    private JButton mostrarButton;
    private JTextArea textArea1;
    private JTextField textField6;
    private JButton buscarPorIdButton;
    private JButton buscarPorPrioridad50Button;
    private JTextArea textArea2;
    private JComboBox comboBox1;
    private JButton agregarButton;
    private JButton activarParticipanteSiguienteButton;
    private JButton activarTodosButton;
    private JButton eliminarParticipateButton;
    private JButton eliminarTodosButton;
    private JButton restaurarUltimoEliminadoButton;
    private JButton restaurarTodosButton;

    public App(){

        setContentPane(panel1);

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirDatos();
            }
        });

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });
        buscarPorIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPredeterminado();
            }
        });
        activarParticipanteSiguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarParticipante();
            }
        });
        activarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarTodos();
            }
        });
        eliminarParticipateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCabeza();
            }
        });
        eliminarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTodos();
            }
        });
    }

    private void buscarPorId(){

    }

    private void restaurarTodos(){
        while (!sn.getPila().isEmpty()) {
            sn.getColaPrioridad().add(sn.getPila().pop());
        }
        JOptionPane.showMessageDialog(null, "Se restauraron todos con exito");
    }

    private void recuperarUltimoEl(){
        sn.getColaPrioridad().add(sn.getPila().pop());
        JOptionPane.showMessageDialog(null, "Se restauro con exito el ultimo elemento");
    }

    private void eliminarTodos(){
        while (!sn.getColaPrioridad().isEmpty()) {
            sn.getPila().add(sn.getColaPrioridad().remove());
        }
        JOptionPane.showMessageDialog(null, "Se eliminaron todos con exito");
    }

    private void eliminarCabeza(){
        sn.getPila().add(sn.getColaPrioridad().remove());
        JOptionPane.showMessageDialog(null, "Se elimino exitosamente la cabeza");
    }

    private void activarTodos(){
        while (!sn.getCola().isEmpty()) {
            sn.getColaPrioridad().add(sn.getCola().remove());
        }
        JOptionPane.showMessageDialog(null, "Se agregaron todos con exito");
    }

    private void activarParticipante(){
        sn.getColaPrioridad().add(sn.getCola().remove());
        JOptionPane.showMessageDialog(null, "Agregado con exito");
    }

    private void agregarPredeterminado(){
        Queue<Persona> prede = new LinkedList<>();
        prede.add(new Persona(1, "Josue", 18, 0, 12));
        prede.add(new Persona(2, "Jose", 18, 0, 12));
        prede.add(new Persona(3, "Mariio", 18, 0, 12));
        prede.add(new Persona(4, "Luigi", 18, 0, 12));
        prede.add(new Persona(5, "Bowser", 18, 0, 12));
        prede.add(new Persona(6, "David", 18, 0, 12));

        Iterator<Persona> iterador = prede.iterator();
        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            if (!sn.buscarPersona(elemento.getNombreCompleto())){
                JOptionPane.showMessageDialog(null, "El nombre" + elemento.getNombreCompleto() + " ya se agrego");
                continue;
            }else{
                sn.getCola().add(elemento);
            }
        }
    }

    private void agregarPersona(){
        sn.agregarPersona(new Persona(Integer.parseInt(textField1.getText()), textField2.getText(), Integer.parseInt(textField3.getText()), Integer.parseInt(textField4.getText()),
                Integer.parseInt(textField5.getText())));
    }

    private void imprimirDatos(){
        String text = "";
        Iterator<Persona> iterador = sn.getCola().iterator();
        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            text+= elemento.imprimirDatos();
        }

        textArea1.setText(text);


    }




}
