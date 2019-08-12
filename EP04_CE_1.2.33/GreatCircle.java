public class GreatCircle { 
    public static void main(String[] args) {
      double x1, y1, x2, y2;
      if(args.length==0)
      {
        System.out.println("Nenhum argumento recebido, calculando distancia entre Sao Paulo - Brasil e Tokyo - Japao");
        x1 = Math.toRadians(-23.55);
        y1 = Math.toRadians(-46.633);
        x2 = Math.toRadians(35.6833);
        y2 = Math.toRadians(139.6833);
      }
      else
      {
        for(int i = 0; i<4; i++) //converte antes no vetor para radianos usando loop for
          args[i] = String.valueOf(Math.toRadians(Double.parseDouble(args[i])));
        x1 = Double.parseDouble(args[0]);
        y1 = Double.parseDouble(args[1]);
        x2 = Double.parseDouble(args[2]);
        y2 = Double.parseDouble(args[3]);
      }
      
      double tmp = 0, d1 = 0, d2 = 0, d3 = 0; //variaveis temporarias para evitar linhas kilometricas e ilegiveis
      System.out.print("Distancia em km por formula derivada da lei dos cossenos: ");
      System.out.println(60 * Math.toDegrees(Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2))) * 1.8522);
      System.out.print("Distancia em km por formula de Haversine: ");
      tmp = (Math.pow(Math.sin((x2 - x1) / 2), 2)) + (Math.cos(x1) * Math.cos(x2) * (Math.pow(Math.sin((y2 - y1) / 2), 2)));
      tmp = 2 * 60 * 1.8522 * Math.toDegrees(Math.asin(Math.sqrt(tmp)));
      System.out.println(tmp);
      System.out.print("Distancia em km por formula da distancia ortodromica: ");
      tmp = y2 - y1;
      d1 = Math.cos(x2) * Math.sin(tmp);
      d2 = Math.cos(x1) * Math.sin(x2) - Math.sin(x1) * Math.cos(x2) * Math.cos(tmp);
      d3 = Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(tmp);
      System.out.println(60 * 1.8522 * Math.toDegrees(Math.atan2(Math.sqrt(d1 * d1 + d2 * d2), d3)));
    }
}