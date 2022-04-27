package com.cl1.vista;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cl1.model.Libro;
import com.cl1.model.Tema;
import com.cl1.dao.LibroDao;
import com.cl1.dao.TemaDao;

public class FrmLibro extends JFrame implements ActionListener, MouseListener{
	
	private JPanel contentPane;
	private JTextField txtTit;
	private JTextField txtPrecio;
	private JTextField txtCant;
	private JTextField txtOrigen;
	private JTable table;
	private JButton btnRegistrar;
	private JComboBox<Tema> cboTema;
	List<Tema> temas = null;
	
	
	LibroDao daoLibro = new LibroDao();
	int idSeleccionado = -1;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLibro frame = new FrmLibro();
							frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmLibro(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblMantenimientoLibro = new JLabel("Mantenimiento Libro");
		lblMantenimientoLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoLibro.setForeground(Color.RED);
		lblMantenimientoLibro.setFont(new Font("Tahoma",Font.BOLD,19));
		lblMantenimientoLibro.setBounds(10, 11, 414, 35);
		contentPane.add(lblMantenimientoLibro);
		JLabel lblTit = new JLabel("Titulo");
		lblTit.setBounds(40, 57, 84, 26);
		contentPane.add(lblTit);
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(40, 88, 84, 26);
		contentPane.add(lblPrecio);
		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setBounds(40, 119, 46, 26);
		contentPane.add(lblCant);
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(40, 149, 46, 26);
		contentPane.add(lblOrigen);
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(40, 186, 46, 26);
		contentPane.add(lblTema);
		//Atributos
		txtTit = new JTextField();
		txtTit.setBounds(152, 60,211, 20);
		contentPane.add(txtTit);
		txtTit.setColumns(10);
		txtPrecio = new JTextField();
		txtPrecio.setBounds(152, 91,211, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtCant = new JTextField();
		txtCant.setBounds(152, 152,211, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		txtOrigen = new JTextField();
		txtOrigen.setBounds(152, 124,211, 20);
		contentPane.add(txtOrigen);
		txtOrigen.setColumns(10);
		cboTema = new JComboBox();
		cboTema.setBounds(152, 189,211, 20);
		contentPane.add(cboTema);
		//Botones
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 229, 114, 23);
		contentPane.add(btnRegistrar);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 276, 414, 184);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new
				DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Id", "Titulo", "Precio", "Cantidad", "Origen", "Tema"
						}
						));
		scrollPane.setViewportView(table);
		
		listaLibro();
		//cargar el combo
		cargaComboTema();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(arg0);
		}
	}
	
	protected void do_btnRegistrar_actionPerformed(ActionEvent arg0){
		String titulo = txtTit.getText().trim();
		String precio = txtPrecio.getText().trim();
		String cantidad = txtCant.getText().trim();
		String origen = txtOrigen.getText().trim();
		Tema tem = (Tema) cboTema.getSelectedItem();
		if(titulo.equals("")){
			mensaje("Campo titulo obligatorio");
			txtTit.requestFocus();
		}
		else if(titulo.matches("[a-zA-Z\\s]{3,50}")==false){
			mensaje("Campo minimo 1 caracteres");
		
			txtTit.requestFocus();
		}
		
		else{
		int boton;
		boton=JOptionPane.showConfirmDialog(this,"Se registro correctamente","SISTEMA",JOptionPane.YES_OPTION);
		}
		Libro libro = new Libro(titulo, precio, cantidad,origen,tem);
		daoLibro.guardarLibro(libro);
		listaLibro();
		
		
		}
		
	
	
	
	 void mensaje(String m) {
		// TODO Auto-generated method stub
		 JOptionPane.showMessageDialog(this, m);
		
	}
	 
	 public void mouseClicked(MouseEvent arg0) {
			if (arg0.getSource() == table) {
				do_table_mouseClicked(arg0);
			}
		}
	 
	 protected void do_table_mouseClicked(MouseEvent arg0) {
			int fila = table.getSelectedRow();
			DefaultTableModel dtm =
					(DefaultTableModel)table.getModel();
			idSeleccionado = (int) dtm.getValueAt(fila, 0);
			String tit = (String) dtm.getValueAt(fila, 1);
			String precio = (String) dtm.getValueAt(fila, 2);
			String cant = (String) dtm.getValueAt(fila, 3);
			String origen = (String) dtm.getValueAt(fila, 4);	
			String tem = (String) dtm.getValueAt(fila, 5);
			txtTit.setText(tit);
			txtPrecio.setText(precio);
			txtCant.setText(cant);
			txtOrigen.setText(origen);
			cboTema.setSelectedItem(obtTemaFromCombo(tem));
		}
		

	private void listaLibro(){
		List<Libro> data = daoLibro.obtTodosLosLibros();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		for (Libro e : data) {
			Object[] fila = {e.getId(),
					e.getTit(),
					e.getPrecio(),
					e.getCant(),
					e.getOrigen(),
					e.getTema().getNombre(),
					};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
	}
	
	private void cargaComboTema(){
		Tema t1 = null;
		Tema t2 = null;
		Tema t3 = null;
		//Crear las carreras
		TemaDao temaDao = new TemaDao();
		t1 = new Tema("Informatica");
		t2 = new Tema("Diseño");
		t3 = new Tema("Tecnologia");
		temaDao.guardarTema(t1);
		temaDao.guardarTema(t2);
		temaDao.guardarTema(t3);
		temas = temaDao.traerTodosTemas();
		for (Tema t : temas) {
			cboTema.addItem(t);
		}
	}
		private Tema obtTemaFromCombo(String s){
			Tema tema = null;
			for(Tema tem : temas){
				if(tem.getNombre().equals(s)){
					tema = tem;
				}
			}
			return tema;
		}



}
