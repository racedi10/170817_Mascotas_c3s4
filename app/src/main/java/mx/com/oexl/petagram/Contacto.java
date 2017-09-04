package mx.com.oexl.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Created by Raul on 21/08/2017.
 */
public class Contacto extends AppCompatActivity {

    private String correoA;
    private String contrasenia;
    private String correoArecibir="racedi@hotmail.com";



    private EditText nombre;
    private EditText correo;
    private EditText mensaje;
    private Button enviar;
    private Session session;
    private String campoNombre;
    private String campoMensaje;
    private String campoCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.bar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre= (EditText) findViewById(R.id.campo_nombre);
        System.out.println(nombre);
        correo=(EditText) findViewById(R.id.campo_correo);
        mensaje=(EditText) findViewById(R.id.campo_comentarios);
        System.out.println(mensaje);
        enviar=(Button)findViewById(R.id.btnEnviar);

        correoA = "racedi10@gmail.com";
        contrasenia = "chicharo26";

        enviar.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                campoNombre= nombre.getText().toString();
                campoCorreo= correo.getText().toString();
                campoMensaje= mensaje.getText().toString();

                Toast toast1 = Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG);
                toast1.show();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();

                //Configuración si usas GMAIL
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");


                //Creating a new session
                session = Session.getDefaultInstance(properties,
                        new javax.mail.Authenticator() {
                            //Authenticating the password
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(correoA, contrasenia);
                            }
                        });

                try {
                    //Creating MimeMessage object
                    MimeMessage mm = new MimeMessage(session);

                    //Setting sender address
                    mm.setFrom(new InternetAddress(correoA));
                    //Adding receiver
                    mm.addRecipient(Message.RecipientType.TO, new InternetAddress(correoArecibir));
                    //Adding nombre
                    mm.setSubject(campoNombre);
                    //Adding message
                    mm.setText("Correo: " + campoCorreo+ "\n"+  " Mensaje: " + campoMensaje );

                    //Sending email
                    Transport.send(mm);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void presionoBoton(View v){
        Intent intent = new Intent(this, DetalleMascota.class);
        System.out.println(intent);

        startActivity(intent);
    }


}

