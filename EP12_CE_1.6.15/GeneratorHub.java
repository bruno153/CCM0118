public class GeneratorHub{
  public static void main(String[] args){
	  /* esse programa tambem recebe um valor H que e o numero de
	     hubs na rede, considerando que por "fixed number" poderia
		 ser qualquer valor. Este programa escolhe para cada hub
		 novas autoridades e links diferentes.
	  */
    //StdOut.print("Insert number of pages: ");
    int N = StdIn.readInt();
    //StdOut.print("Insert number of links: ");
    int M = StdIn.readInt();
    //StdOut.print("Insert number of Hubs and Authorities: ");
    int H = StdIn.readInt();

    int perc = N/10; //10% of the pages
    int[] link = new int[perc];
    int[] authority = new int[perc];
    int tmp = 0;
    boolean stop = false;

	tmp=N+2*H;
	StdOut.println(tmp);

    for(int i = 0; i < M; i++){//prints the randomized links
      StdOut.println(StdRandom.uniform(0, N) + " " + StdRandom.uniform(0, N));
    }

	//computes the Hubs
	for(int k = 0; k < H; k++){
		//choose the links for the Hubs
		for(int i = 0; i < perc; i++){
			if(i==0) //exception for first iteration
				link[0] = StdRandom.uniform(0, N);
			else{
				while(!stop){
					stop = true;
					tmp = StdRandom.uniform(0, N);
					for(int j = 0; j < i; j++){
						if(tmp==link[j]){
							stop = false;
							break;
						}
					}
				}
				link[i] = tmp;
				stop = false;
			}
		}
		//prints the links involving the hubs
		for(int i = 0; i < perc; i++){
			tmp = N+k;
			StdOut.println(link[i] + " " + tmp);
		}
    //prints a random link to avoid errors on transition.java
    StdOut.println(tmp + " " + StdRandom.uniform(0, N));
	  }
    //computes the Authorities
    for(int k = 0; k < H; k++){
      //choose the links for the Authorities
      for(int i = 0; i < perc; i++){
        if(i==0) //exception for first iteration
          link[0] = StdRandom.uniform(0, N);
        else{
          while(!stop){
            stop = true;
            tmp = StdRandom.uniform(0, N);
            for(int j = 0; j < i; j++){
              if(tmp==link[j]){
                stop = false;
                break;
              }
            }
          }
          link[i] = tmp;
          stop = false;
        }
      }
      //prints the links involving the Authorities
      for(int i = 0; i < perc; i++){
        tmp = N+H+k;
        StdOut.println(tmp + " " + link[i]);
      }
      //prints a random link to avoid errors on transition.java
      StdOut.println(StdRandom.uniform(0, N) + " " + tmp);
      }
  }
}
