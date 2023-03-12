package inclui.formulario_simple;

import inclui.formularios.clui_formularios;
import inclui.formularios.control_selecciones;
import static inclui.formularios.control_selecciones.k_control_selecciones_letras_por_linea_num;
import inclui.formularios.control_entradas;
import static inclui.formularios.control_entradas.k_entradas_tipo_email;
import static inclui.formularios.control_entradas.k_entradas_tipo_fecha;
import static inclui.formularios.control_entradas.k_entradas_tipo_fecha_y_hora;
import static inclui.formularios.control_entradas.k_entradas_tipo_numero;
import static inclui.formularios.control_entradas.k_entradas_tipo_password;
import static inclui.formularios.control_entradas.k_entradas_tipo_radio;
import static inclui.formularios.control_entradas.k_entradas_tipo_reset;
import static inclui.formularios.control_entradas.k_entradas_tipo_submit;
import static inclui.formularios.control_entradas.k_entradas_tipo_telefono;
import static inclui.formularios.control_entradas.k_entradas_tipo_texto;
import inclui.formularios.control_textareas;
import innui.formularios.controles;
import static innui.formularios.controles.k_opciones_mapa_no_requerido;
import static innui.formularios.formularios.k_fase_procesamiento;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import innui.modelos.modelos;
import static java.lang.System.exit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import static inclui.formularios.control_selecciones.k_opciones_mapa_control_selecciones;

/**
 *
 * @author emilio
 */
public class Formulario_simple extends iniciales {
    public static String k_in_ruta = "in/inclui/formulario_simple/in";
    public static String k_paises_seleccion_ruta = "/re/paises.properties";
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
    public static String k_clave_comentarios = "clave_comentarios";
    public static String k_clave_reset = "reset";
    public static String k_clave_submit = "submit";
    public static String k_formulario_simple_letras_por_linea_num = "formulario_simple_letras_por_linea_num";
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
                    clui_formulario.escribir_linea_error(ok.getTxt(), ok);
                    if (ok.es == false) { return ok.es; }
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
                    crear_formulario_simple(ok);
                    if (ok.es == false) { break; }
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
    /**
     * Valida el formulario
     * @param ok
     * @param extra_array
     * @return
     * @throws Exception 
     */
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
                clui_formulario.escribir_linea_error(tr.in(in, "La clave y la clave repetida no coinciden. "), ok);
                if (ok.es == false) { return ok.es; }
                clui_formulario.repetir(ok);
            }
            return ok.es;
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }
    /**
     * Procesa el formulario
     * @param ok
     * @param extra_array
     * @return
     * @throws Exception 
     */
    public boolean procesar_formulario_simple(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            clui_formulario.procesar(ok);
            if (ok.es == false) { return ok.es; }
            if (clui_formulario.ser_cancelar(ok) == false) {
                List<Entry<String,Object>> objetos_lista;
                String texto;
                objetos_lista = clui_formulario.exportar_valores(ok);
                if (ok.es == false) { return ok.es; }
                for (Entry<String, Object> entry: objetos_lista) {
                    if (entry.getValue() == null) {
                        texto = "";
                    } else {
                        texto = entry.getValue().toString();
                    }
                    escribir_linea(entry.getKey() + " \"" + texto + "\"", ok);
                    if (ok.es == false) { return ok.es; }
                }
            } else {
                escribir_linea(tr.in(in, "Formulario cancelado. "), ok);
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }    
    /**
     * Crea el formulario
     * @param ok
     * @param extra_array
     * @return
     * @throws Exception 
     */
    public boolean crear_formulario_simple(oks ok, Object... extra_array) throws Exception {
        if (ok.es == false) { return ok.es; }
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            control_entradas entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_nombre_apellidos, null, tr.in(in, "Introduzca su nombre y sus apellidos. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_radio = new control_entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, "XY", tr.in(in, "Opción 1/3: ¿Sexo XY (macho)? "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio = new control_entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, "XX", tr.in(in, "Opción 2/3: ¿Sexo XX (hembra)? "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio = new control_entradas();
            entrada_radio.iniciar(k_entradas_tipo_radio, ok);
            if (ok.es == false) { return ok.es; }
            entrada_radio.poner_en_formulario(clui_formulario, k_clave_sexo, "..", tr.in(in, "Opción 3/3: ¿Otro (No XY y no XX)? "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_fecha = new control_entradas();
            entrada_fecha.iniciar(k_entradas_tipo_fecha, ok);
            if (ok.es == false) { return ok.es; }
            entrada_fecha.poner_en_formulario(clui_formulario, k_clave_fecha, null, tr.in(in, "Introduzca su fecha de nacimiento. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_email = new control_entradas();
            entrada_email.iniciar(k_entradas_tipo_email, ok);
            if (ok.es == false) { return ok.es; }
            entrada_email.poner_en_formulario(clui_formulario, k_clave_email, null, tr.in(in, "Introduzca su email. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_telefono = new control_entradas();
            entrada_telefono.iniciar(k_entradas_tipo_telefono, ok);
            if (ok.es == false) { return ok.es; }
            entrada_telefono.poner_en_formulario(clui_formulario, k_clave_telefono, null, tr.in(in, "Introduzca su teléfono. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_calle, null, tr.in(in, "Introduzca primera parte de su dirección (solo nombre de la calle). "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_numero = new control_entradas();
            entrada_numero.iniciar(k_entradas_tipo_numero, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero.poner_en_formulario(clui_formulario, k_clave_portal_num, null, tr.in(in, "Introduzca el número del portal de su dirección. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            Map <String, Object> opciones_mapa = new HashMap<>();
            opciones_mapa.put(k_opciones_mapa_no_requerido, true);
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_calle_extra, null, tr.in(in, "Introduzca parte extra de su dirección (después se pedirá piso y puerta). "), opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero = new control_entradas();
            entrada_numero.iniciar(k_entradas_tipo_numero, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero.poner_en_formulario(clui_formulario, k_clave_piso_num, null, tr.in(in, "Introduzca el piso de su dirección (0 si no hay). "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_puerta_num, null, tr.in(in, "Introduzca la puerta de su dirección. "), opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_vivienda_extra, null, tr.in(in, "Introduzca parte extra de identificacion de su vivienda (después se pedirá la ciudad). "), opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_ciudad, null, tr.in(in, "Introduzca la ciudad. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero = new control_entradas();
            entrada_numero.iniciar(k_entradas_tipo_numero, ok);
            if (ok.es == false) { return ok.es; }
            entrada_numero.poner_en_formulario(clui_formulario, k_clave_codigo_postal, null, tr.in(in, "Introduzca el código postal. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto = new control_entradas();
            entrada_texto.iniciar(k_entradas_tipo_texto, ok);
            if (ok.es == false) { return ok.es; }
            entrada_texto.poner_en_formulario(clui_formulario, k_clave_provincia_estado, null, tr.in(in, "Introduzca la provincia/estado. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_selecciones paises_seleccion = new control_selecciones();
            paises_seleccion.iniciar(null, ok);
            if (ok.es == false) { return ok.es; }
            paises_seleccion.cargar_control_con_propiedades(k_paises_seleccion_ruta, ok);
            if (ok.es == false) { return ok.es; }
            String letras_por_linea = properties.getProperty(k_formulario_simple_letras_por_linea_num);
            Integer letras_por_linea_num = null;
            try {
                letras_por_linea_num = Integer.valueOf(letras_por_linea);
            } catch (Exception e) {
                ok.setTxt("Valor con formato incorrecto: " + k_formulario_simple_letras_por_linea_num);
            }
            if (ok.es == false) { return ok.es; }
            opciones_mapa.put(k_control_selecciones_letras_por_linea_num, letras_por_linea_num);
            paises_seleccion.poner_en_formulario(clui_formulario, k_clave_pais, null, tr.in(in, "Introduzca el país. "), opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_contraseña = new control_entradas();
            entrada_contraseña.iniciar(k_entradas_tipo_password, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña.poner_en_formulario(clui_formulario, k_clave_password, null, tr.in(in, "Introduzca la contraseña que desea establecer. "), null, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña = new control_entradas();
            entrada_contraseña.iniciar(k_entradas_tipo_password, ok);
            if (ok.es == false) { return ok.es; }
            entrada_contraseña.poner_en_formulario(clui_formulario, k_clave_password_repetida, null, tr.in(in, "Repita la contraseña que desea establecer. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_fecha_y_hora = new control_entradas() {
                @Override
                public boolean _validar_fecha_y_hora(Object objeto_a_validar, oks ok, Object ... extras_array) throws Exception {
                    try {
                        if (ok.es == false) { return false; }
                        super._validar_fecha_y_hora(objeto_a_validar, ok, extras_array);
                        if (ok.es == false) { return false; }
                        Date date;
                        date = (Date) super._convertir(k_fase_procesamiento, objeto_a_validar, ok, extras_array);
                        if (ok.es == false) { return false; }
                        Date actual_date = new Date();
                        if (actual_date.getTime() > date.getTime()) {
                            ok.setTxt(tr.in(in, "La fecha introducida no puede ser anterior a la fecha actual. "));
                            return ok.es;
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        Calendar actual_calendar = Calendar.getInstance();
                        actual_calendar.setTime(actual_date);
                        int año = calendar.get(Calendar.YEAR);
                        int actual_año = actual_calendar.get(Calendar.YEAR);
                        int dia_del_año = calendar.get(Calendar.DAY_OF_YEAR);
                        int actual_dia_del_año = actual_calendar.get(Calendar.DAY_OF_YEAR);
                        int dias_del_año = actual_calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
                        if (año == actual_año) {
                            if ((actual_dia_del_año + 30) < dia_del_año) {
                                ok.setTxt(tr.in(in, "La fecha introducida no puede ser más de 30 días posterior a la actual. "));
                                return ok.es;
                            }
                        } else if (año == (actual_año + 1)) {
                            if (((actual_dia_del_año + 30) % dias_del_año) >= 31) {
                                ok.setTxt(tr.in(in, "La fecha introducida no puede ser más de 30 días posterior a la actual. "));
                                return ok.es;
                            } else if (dia_del_año >= ((actual_dia_del_año + 30) % dias_del_año)) {
                                ok.setTxt(tr.in(in, "La fecha introducida no puede ser más de 30 días posterior a la actual. "));
                                return ok.es;                                
                            }
                        } else {
                            ok.setTxt(tr.in(in, "La fecha introducida no puede ser más de 30 días posterior a la actual. "));
                            return ok.es;
                        }
                    } catch (Exception e) {
                        ok.setTxt(e);
                    }
                    return ok.es;
                }
            };
            entrada_fecha_y_hora.iniciar(k_entradas_tipo_fecha_y_hora, ok);
            if (ok.es == false) { return ok.es; }
            entrada_fecha_y_hora.poner_en_formulario(clui_formulario, k_clave_fecha_y_hora_disponibilidad, null, tr.in(in, "Introduzca la fecha y la hora a partir de la que desea que la información proporcionada quede disponible . "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_textareas textarea = new control_textareas();
            textarea.iniciar(null, ok);
            textarea.iniciar(k_entradas_tipo_reset, ok);
            textarea.poner_en_formulario(clui_formulario, k_clave_comentarios, null, tr.in(in, "Comentarios adicionales: "), opciones_mapa, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_reset = new control_entradas();
            entrada_reset.iniciar(k_entradas_tipo_reset, ok);
            if (ok.es == false) { return ok.es; }
            entrada_reset.poner_en_formulario(clui_formulario, k_clave_reset, null, tr.in(in, "¿Desea revisar o volver a hacer el formulario?. "), null, ok);
            if (ok.es == false) { return ok.es; }
            control_entradas entrada_submit = new control_entradas();
            entrada_submit.iniciar(k_entradas_tipo_submit, ok);
            if (ok.es == false) { return ok.es; }
            entrada_submit.poner_en_formulario(clui_formulario, k_clave_submit, null, tr.in(in, "¿Desea enviar el formulario? (Si no es así, se cancelará). "), null, ok);
            if (ok.es == false) { return ok.es; }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.es;
    }    

}
