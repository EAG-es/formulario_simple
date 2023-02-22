package inclui.formulario_simple;

import inclui.formularios.clui_formularios;
import inclui.formularios.entradas;
import static inclui.formularios.entradas.k_entradas_tipo_color;
import static inclui.formularios.entradas.k_entradas_tipo_email;
import static inclui.formularios.entradas.k_entradas_tipo_fecha;
import static inclui.formularios.entradas.k_entradas_tipo_fecha_y_hora;
import static inclui.formularios.entradas.k_entradas_tipo_hora;
import static inclui.formularios.entradas.k_entradas_tipo_numero;
import static inclui.formularios.entradas.k_entradas_tipo_password;
import static inclui.formularios.entradas.k_entradas_tipo_radio;
import static inclui.formularios.entradas.k_entradas_tipo_reset;
import static inclui.formularios.entradas.k_entradas_tipo_submit;
import static inclui.formularios.entradas.k_entradas_tipo_telefono;
import static inclui.formularios.entradas.k_entradas_tipo_texto;
import innui.formularios.controles;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import static java.lang.System.exit;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author emilio
 */
public class Formulario_simple extends iniciales {
    public static String k_in_ruta = "in/inclui/formulario_simple/in";
    public static String k_clave_nombre_apellidos = "nombre_apellidos";
    public static String k_clave_sexo = "sexo";
    public static String k_clave_fecha = "fecha";
    public static String k_clave_hora = "hora";
    public static String k_clave_color = "color";
    public static String k_clave_email = "email";
    public static String k_clave_password = "password";
    public static String k_clave_password_repetida = "password_repetida";
    public static String k_clave_telefono = "telefono";
    public static String k_clave_calle = "calle";
    public static String k_clave_portal_num = "portal_num";
    public static String k_clave_calle_extra = "calle_extra";
    public static String k_clave_piso_num = "piso_num";
    public static String k_clave_puerta_num = "puerta_num";
    public static String k_clave_vivienda_extra = "vivienda_extra";
    public static String k_clave_ciudad = "ciudad";
    public static String k_clave_codigo_postal = "codigo_postal";
    public static String k_clave_provincia_estado = "provincia_estado";
    public static String k_clave_pais = "pais";
    public static String k_clave_fecha_y_hora_disponibilidad = "fecha_y_hora_disponibilidad";
    public static String k_clave_reset = "reset";
    public static String k_clave_submit = "submit";
    clui_formularios clui_formulario = new clui_formularios() {
        @Override
        public boolean _terminar_formulario(String modo_operacion, oks ok, Object ... extras_array) throws Exception {
            try {
                if (ok.es == false) { return false; }
                if (clui_formulario._es_cancelar) {
                    return ok.es;
                }
                ser_formulario_valido(ok);
                if (ok.es == false) {
                    oks ok_1 = new oks();
                    clui_formulario.escribir_linea_error(ok.getTxt(), ok_1);
                    if (ok_1.es == false) { return ok_1.es; }
                    clui_formulario.repetir(ok);
                    if (ok.es == false) { return false; }
                    ok.iniciar();
                }
            } catch (Exception e) {
                throw e;
            }
            return ok.es;
        }
    };
    /**
     * Inicio de la aplicación
     * @param args 
     */
    public static void main(String[] args) {
        oks ok = new oks();
        try {
            ResourceBundle in = null;
            Formulario_simple formulario_simple = null;
            try {
                formulario_simple = new Formulario_simple();
                formulario_simple.run(ok);
            } catch (Exception e) {
                ok.setTxt(e);
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            System.err.println(ok.txt);
            exit(1);
        } else {
            exit(0);
        }
    }    
    /**
     * Inicio de la aplicación desde un objeto instanciado
     * @param ok Comunicar resultados
     * @param extras_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean run(oks ok, Object ... extras_array) throws Exception {
        try {
            if (ok.es == false) { return ok.es; }
            iniciar(ok);
            if (ok.es) {
                while (true) {
                    procesar_formulario_simple(ok);
                    if (ok.es == false) { break; }
                    break;
                }
                terminar(ok);
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean iniciar(oks ok, Object... extra_array) throws Exception {
        // Iniciar clase principal de la librería
        _iniciar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _iniciar_desde_clase(this.getClass(), ok);
        return ok.es;
    }

    @Override
    public boolean terminar(oks ok, Object... extra_array) throws Exception {
        // Terminar clase principal de la librería
        _terminar_desde_clase(modelos.class, ok);
        if (ok.es == false) { return ok.es; }
        _terminar_desde_clase(this.getClass(), ok);
        return ok.es;
    }
    
    public boolean ser_formulario_valido(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        ResourceBundle in;
        try {
            String password = "";
            String password_repetida = "";
            for (controles control : clui_formulario._controles_lista) {
                if (control.clave.equals(k_clave_password)) {
                    password = (String) control.valor;
                } else if (control.clave.equals(k_clave_password_repetida)) {
                    password_repetida = (String) control.valor;
                }
            }
            if (password.equals(password_repetida) == false) {
                in = ResourceBundle.getBundle(k_in_ruta);
                ok.setTxt(tr.in(in, "La clave y la clave repetida no coinciden. "));
            }
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }

    public boolean procesar_formulario_simple(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            entradas entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_nombre_apellidos, tr.in(in, "Introduzca su nombre y sus apellidos. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_radio = new entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, tr.in(in, "Opción 1/3: ¿Sexo XY (macho)? "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio = new entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, tr.in(in, "Opción 2/3: ¿Sexo XX (hembra)? "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio = new entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, tr.in(in, "Opción 3/3: ¿No macho y no hembra? "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_fecha = new entradas();
            entrada_fecha.iniciar(k_entradas_tipo_fecha, ok);
            if (ok.es == false) { return ok.es; }
            entrada_fecha.poner_en_formulario(clui_formulario, k_clave_fecha, tr.in(in, "Introduzca su fecha de nacimiento. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_hora = new entradas();
            entrada_hora.iniciar(k_entradas_tipo_hora, ok);
            if (ok.es == false) { return ok.es; }
            entrada_hora.poner_en_formulario(clui_formulario, k_clave_hora, tr.in(in, "Introduzca la hora actual. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_color = new entradas();
            entrada_color.iniciar(k_entradas_tipo_color, ok);
            if (ok.es == false) { return ok.es; }
            entrada_color.poner_en_formulario(clui_formulario, k_clave_color, tr.in(in, "Introduzca su color favorito. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_email = new entradas();
            entrada_email.iniciar(k_entradas_tipo_email, ok);
            if (ok.es == false) { return ok.es; }
            entrada_email.poner_en_formulario(clui_formulario, k_clave_email, tr.in(in, "Introduzca su email. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_contraseña = new entradas();
            entrada_contraseña.iniciar(k_entradas_tipo_password, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña.poner_en_formulario(clui_formulario, k_clave_password, tr.in(in, "Introduzca la contraseña que desea establecer. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña = new entradas();
            entrada_contraseña.iniciar(k_entradas_tipo_password, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña.poner_en_formulario(clui_formulario, k_clave_password_repetida, tr.in(in, "Repita la contraseña que desea establecer. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_telefono = new entradas();
            entrada_telefono.iniciar(k_entradas_tipo_telefono, ok);
            if (ok.es == false) { return ok.es; }
            entrada_telefono.poner_en_formulario(clui_formulario, k_clave_telefono, tr.in(in, "Introduzca su teléfono. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_calle, tr.in(in, "Introduzca primera parte de su dirección (solo nombre de la calle). "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_numero = new entradas();
            entrada_numero.iniciar(k_entradas_tipo_numero, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero.poner_en_formulario(clui_formulario, k_clave_portal_num, tr.in(in, "Introduzca el número del portal de su dirección. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_calle_extra, tr.in(in, "Introduzca parte extra de su dirección (después se pedirá piso y puerta). "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero = new entradas();
            entrada_numero.iniciar(k_entradas_tipo_numero, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero.poner_en_formulario(clui_formulario, k_clave_piso_num, tr.in(in, "Introduzca el piso de su dirección (0 si no hay). "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_puerta_num, tr.in(in, "Introduzca la puerta de su dirección. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_vivienda_extra, tr.in(in, "Introduzca parte extra de identificacion de su vivienda (después se pedirá la ciudad). "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_ciudad, tr.in(in, "Introduzca la ciudad. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_codigo_postal, tr.in(in, "Introduzca el código postal. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_provincia_estado, tr.in(in, "Introduzca la provincia/estado. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_pais, tr.in(in, "Introduzca el país. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_fecha_y_hora = new entradas() {
                @Override
                public boolean _validar_fecha_y_hora(Object objeto_a_validar, oks ok, Object ... extras_array) throws Exception {
                    try {
                        if (ok.es == false) { return false; }
                        super._validar_fecha_y_hora(objeto_a_validar, ok, extras_array);
                        if (ok.es == false) { return false; }
                        Date date;
                        date = (Date) super._convertir(k_fase_procesamiento, objeto_a_validar, ok, extras_array);
                        if (ok.es == false) { return false; }
                        if (date == null) {
                            return true;
                        }
                        Date actual_date = new Date();
                        if (actual_date.getTime() < date.getTime()) {
                            return true;
                        } else {
                            ok.setTxt(tr.in(in, "La fecha introducida no puede ser anterior a la fecha actual. "));
                        }
                    } catch (Exception e) {
                        ok.setTxt(e);
                    }
                    return ok.es;
                }
            };
            entrada_fecha_y_hora.iniciar(k_entradas_tipo_fecha_y_hora, ok);
            if (ok.es == false) { return ok.es; }
            entrada_fecha_y_hora.poner_en_formulario(clui_formulario, k_clave_fecha_y_hora_disponibilidad, tr.in(in, "Introduzca la fecha y la hora a partir de la que desea que la información proporcionada quede disponible . "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_reset = new entradas();
            entrada_reset.iniciar(k_entradas_tipo_reset, ok);
            if (ok.es == false) { return ok.es; }
            entrada_reset.poner_en_formulario(clui_formulario, k_clave_reset, tr.in(in, "¿Desea revisar o volver a hacer el formulario?. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entradas entrada_submit = new entradas();
            entrada_submit.iniciar(k_entradas_tipo_submit, ok);
            if (ok.es == false) { return ok.es; }
            entrada_submit.poner_en_formulario(clui_formulario, k_clave_submit, tr.in(in, "¿Desea enviar el formulario? (Si no es así, se cancelará). "), null, ok);
            if (ok.es == false) { return ok.es; }
            clui_formulario.procesar(ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }    
}
