package EjemploLector;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.*;
import com.digitalpersona.onetouch.processing.*;
import com.digitalpersona.onetouch.verification.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author ING JARC
 */
public class Main extends JDialog {
    
    private JButton btnGuardar;
    private JButton btnIdentificar;
    private JButton btnSalir;
    private JButton btnVerificar;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JLabel lblImagenHuella;
    private JPanel panBtns;
    private JPanel panHuellas;
    private JTextArea txtArea;
    
    //public static void main(String args[]) {
    //    new Main().setVisible(true);
    //}
    
    public Main() {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception e) {}
        initComponents();
        txtArea.setEditable(false);
    }
    
    private void initComponents() {

        panHuellas = new JPanel();
        jPanel1 = new JPanel();
        lblImagenHuella = new JLabel();
        panBtns = new JPanel();
        jPanel2 = new JPanel();
        btnSalir = new JButton();
        btnVerificar = new JButton();
        btnIdentificar = new JButton();
        btnGuardar = new JButton();
        jPanel4 = new JPanel();
        jScrollPane1 = new JScrollPane();
        txtArea = new JTextArea();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Huellas Dactilares - J@RC 2011 4500 Fingerprint Reader DP");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }

            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panHuellas.setBorder(BorderFactory.createTitledBorder(null, "Huella Digital Capturada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panHuellas.setPreferredSize(new java.awt.Dimension(400, 270));
        panHuellas.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(lblImagenHuella, java.awt.BorderLayout.CENTER);

        panHuellas.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panHuellas, java.awt.BorderLayout.NORTH);

        panBtns.setBorder(BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        panBtns.setPreferredSize(new java.awt.Dimension(400, 190));
        panBtns.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(366, 90));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnIdentificar.setText("Identificar");
        btnIdentificar.setPreferredSize(new java.awt.Dimension(71, 23));
        btnIdentificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnIdentificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerificar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVerificar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnIdentificar, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );

        panBtns.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Lucida Sans", 1, 10));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panBtns.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(366, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 10));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Created By: Ing JARC");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(299, Short.MAX_VALUE)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panBtns.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panBtns, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 459) / 2, (screenSize.height - 499) / 2, 459, 499);
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre a verificar:");
        verificarHuella(nombre);
        recruiter.clear();
    }

    private void btnIdentificarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            identificarHuella();
            recruiter.clear();
        } catch (IOException ex) {
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarHuella();
        recruiter.clear();
        lblImagenHuella.setIcon(null);
        start();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Iniciar();
        start();
        EstadoHuellas();
        btnGuardar.setEnabled(false);
        btnIdentificar.setEnabled(false);
        btnVerificar.setEnabled(false);
        btnSalir.grabFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stop();
    }//GEN-LAST:event_formWindowClosing

//Varible que permite iniciar el dispositivo de lector de huella conectado
// con sus distintos metodos.
    private DPFPCapture reader = DPFPGlobal.getCaptureFactory().createCapture();

//Varible que permite establecer las capturas de la huellas, para determina sus caracteristicas
// y poder estimar la creacion de un template de la huella para luego poder guardarla
    private DPFPEnrollment recruiter = DPFPGlobal.getEnrollmentFactory().createEnrollment();

//Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
// o verificarla con alguna guardada en la BD
    private DPFPVerification verifier = DPFPGlobal.getVerificationFactory().createVerification();

//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
// necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    protected void Iniciar() {
        reader.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });

        reader.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
                    }
                });
            }
        });

        reader.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido quitado del Lector de Huella");
                    }
                });
            }
        });

        reader.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("Error: " + e.getError());
                    }
                });
            }
        });
    }

    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
        if (featuresinscripcion != null) {
            try {
                System.out.println("Las Caracteristicas de la Huella han sido creada");
                recruiter.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

                // Dibuja la huella dactilar capturada.
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

                btnVerificar.setEnabled(true);
                btnIdentificar.setEnabled(true);

            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());
            } finally {
                EstadoHuellas();
                // Comprueba si la plantilla se ha creado.
                switch (recruiter.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
                        stop();
                        setTemplate(recruiter.getTemplate());
                        EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
                        btnIdentificar.setEnabled(false);
                        btnVerificar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                        btnGuardar.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
                        recruiter.clear();
                        stop();
                        EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        lblImagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public void EstadoHuellas() {
        EnviarTexto("Muestra de Huellas Necesarias para Guardar Template " + recruiter.getFeaturesNeeded());
    }

    public void EnviarTexto(String string) {
        txtArea.append(string + "\n");
    }

    public void start() {
        reader.startCapture();
        EnviarTexto("Utilizando el Lector de Huella Dactilar ");
    }

    public void stop() {
        reader.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ");
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    Database con = new Database();
    /*
     * Guarda los datos de la huella digital actual en la base de datos
     */

    public void guardarHuella() {
        //Obtiene los datos del template de la huella actual
        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamañoHuella = template.serialize().length;

        //Pregunta el nombre de la persona a la cual corresponde dicha huella
        String nombre = JOptionPane.showInputDialog("Nombre:");
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar(); //establece la conexion con la BD
            PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO usuarios(nombre, huella) values(?,?)");

            guardarStmt.setString(1, nombre);
            guardarStmt.setBinaryStream(2, datosHuella, tamañoHuella);
            //Ejecuta la sentencia
            guardarStmt.execute();
            guardarStmt.close();
            JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
            con.desconectar();
            btnGuardar.setEnabled(false);
            btnVerificar.grabFocus();
        } catch (SQLException ex) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.");
        } finally {
            con.desconectar();
        }
    }

    /**
     * Verifica la huella digital actual contra otra en la base de datos
     */
    public void verificarHuella(String nom) {
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();
            //Obtiene la plantilla correspondiente a la persona indicada
            PreparedStatement verificarStmt = c.prepareStatement("SELECT huehuella FROM somhue WHERE huenombre=?");
            verificarStmt.setString(1, nom);
            ResultSet rs = verificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            if (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huehuella");
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // plantilla guardada al usuario especifico en la base de datos
                DPFPVerificationResult result = verifier.verify(featuresverificacion, getTemplate());

                //compara las plantilas (actual vs bd)
                if (result.isVerified()) {
                    JOptionPane.showMessageDialog(null, "Las huella capturada coinciden con la de " + nom, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No corresponde la huella con " + nom, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
                }

                //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
            } else {
                JOptionPane.showMessageDialog(null, "No existe un registro de huella para " + nom, "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al verificar los datos de la huella.");
        } finally {
            con.desconectar();
        }
    }

    /**
     * Identifica a una persona registrada por medio de su huella digital
     */
    public void identificarHuella() throws IOException {
        try {
            //Establece los valores para la sentencia SQL
            Connection c = con.conectar();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = c.prepareStatement("SELECT huenombre,huehuella FROM somhue");
            ResultSet rs = identificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huehuella");
                String nombre = rs.getString("huenombre");
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = verifier.verify(featuresverificacion, getTemplate());

                //compara las plantilas (actual vs bd)
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidió.
                if (result.isVerified()) {
                    //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
                    JOptionPane.showMessageDialog(null, "Las huella capturada es de " + nombre, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
            JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            setTemplate(null);
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al identificar huella dactilar." + e.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
}
