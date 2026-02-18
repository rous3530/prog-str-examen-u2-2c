 public class  U2Service {
    // ID válido: exactamente 8 caracteres alfanuméricos (A-Z, a-z, 0-9), sin espacios.
    public static boolean esIdValido(String id) {
        if (id == null) return false;

        if (id.isBlank()) return false;

        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            boolean esLetra = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
            boolean esDigito = (ch >= '0' && ch <= '9');

            if (!esDigito && !esLetra)  return false;
        }
        return true;
    }

    public static boolean esHorarioPermitido(int hora) {
        if (hora >7 && hora <19){
            System.out.println("es horario permitido");
            return true;
        }else {
        return false;
        }
    }
}
