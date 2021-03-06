package dwarf;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Crashes are unexpected shutdowns of the Dwarf 2D Engine. When the engine
 * crashes, it typically closes immediately, though it may show an error report
 * marking the location of the exception which caused the crash.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see javax.swing.JFrame
 * @see java.lang.Exception
 * @see java.lang.Throwable
 *
 * @see dwarf.DwarfError
 * @see dwarf.DwarfException
 */
@SuppressWarnings("serial")
public class Crashform extends javax.swing.JFrame {

    private final JTextArea txtDisplay;
    private final JScrollPane jScrollPane;

    /**
     * Creates new form Crashform with a specified <code>Throwable</code> as the
     * cause.
     *
     * @param name name of the form
     * @param cause the cause of the crash
     */
    public Crashform(String name, Throwable cause) {
        super(name + " - " + cause.getClass().getName());

        this.txtDisplay = new javax.swing.JTextArea();
        this.jScrollPane = new javax.swing.JScrollPane();

        this.txtDisplay.setRows(5);
        this.txtDisplay.setColumns(20);
        this.txtDisplay.setEditable(false);
        this.jScrollPane.setViewportView(txtDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        super.getContentPane().setLayout(layout);
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
        super.pack();

        super.toFront();
        super.setLocationRelativeTo(dwarf.engine.core.Window.getParent());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setEnabled(true);
        //super.setVisible(true);

        this.setDisplay(name, cause);
    }

    /**
     * Creates new form Crashform with a specified <code>Throwable</code> as the
     * cause.
     *
     * @param cause the cause of the crash
     */
    public Crashform(Throwable cause) {
        this("Dwarf2D", cause);
    }

    public JTextArea getDisplay() {
        return this.txtDisplay;
    }

    public dwarf.Crashform get() {
        return this;
    }

    private void setDisplay(String name, Throwable cause) {
        String msg = " ---" + name + " Crash Report--" + "\n \n";

        //system details:
        msg += " Time: " + dwarf.time.getTime() + " " + dwarf.time.getDate() + "\n";
        msg += " OS: " + dwarf.system.getOSName()
                + " (" + dwarf.system.getOSArch() + ")"
                + " version " + dwarf.system.getOSVersion() + "\n";
        msg += " Java: " + dwarf.system.getJavaVersion() + " "
                + dwarf.system.getJavaVender()
                + " (" + dwarf.system.getJavaVenderUrl() + ")" + "\n";
        msg += " LWJGL: " + dwarf.system.getLWJGLVersion() + "\n \n";

        //crash details:
        msg += " " + cause.toString() + "\n";
        for (StackTraceElement element : cause.getStackTrace()) {
            msg += "\t " + element + "\n";
        }

        this.txtDisplay.setText(msg);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Crashform(new java.lang.Exception("Crashform - Test")).setVisible(true);
    }
}
