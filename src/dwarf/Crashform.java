package dwarf;

/**
 * Crashes are unexpected shutdowns of the Dwarf 2D Engine. When the engine
 * crashes, it typically closes immediately, though it may show an error report
 * marking the location of the exception which caused the crash.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see javax.swing.JFrame
 *
 * @see dwarf.DwarfError
 * @see dwarf.DwarfException
 * @see java.lang.Exception
 */
@SuppressWarnings("serial")
public class Crashform extends javax.swing.JFrame {

    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea txtDisplay;

    /**
     * Creates new form Crashform.
     *
     * @param ex the cause of the error
     */
    public Crashform(Exception ex) {
        super("Dwarf2D - " + ex.getClass().getName());
        initComponents();

        super.setLocationRelativeTo(dwarf.engine.core.Window.getParent());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.toFront();
        super.setEnabled(true);
        super.setVisible(true);

        this.setDisplay(ex);
    }

    public javax.swing.JTextArea getDisplay() {
        return this.txtDisplay;
    }

    public dwarf.Crashform get() {
        return this;
    }

    private void setDisplay(Exception ex) {
        String msg = " ---Dwarf Crash Report--" + "\n \n";

        //system details
        msg += " Time: " + dwarf.time.getTime() + " " + dwarf.time.getDate() + "\n";
        msg += " OS: " + dwarf.system.getOSName()
                + " (" + dwarf.system.getOSArch() + ")"
                + " version " + dwarf.system.getOSVersion() + "\n";
        msg += " Java: " + dwarf.system.getJavaVersion() + " "
                + dwarf.system.getJavaVender()
                + " (" + dwarf.system.getJavaVenderUrl() + ")" + "\n";
        msg += " LWJGL: " + dwarf.system.getLWJGLVersion() + "\n \n";

        //exception details
        msg += " " + ex.toString() + "\n";
        for (StackTraceElement element : ex.getStackTrace()) {
            msg += "\t " + element + "\n";
        }

        this.txtDisplay.setText(msg);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        this.jScrollPane = new javax.swing.JScrollPane();
        this.txtDisplay = new javax.swing.JTextArea();

        this.txtDisplay.setEditable(false);
        this.txtDisplay.setColumns(20);
        this.txtDisplay.setRows(5);
        this.jScrollPane.setViewportView(txtDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crashform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Crashform(new Exception());
        });
    }
}
