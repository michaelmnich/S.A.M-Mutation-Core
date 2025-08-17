/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.mutationtest.sam;

import org.pitest.mutationtest.sam.ui.Iui;
import org.pitest.mutationtest.sam.ui.console.ConsoleUi;
import org.pitest.mutationtest.sam.web.WebSocketWorkerNode;
import java.util.Arrays;
/**
 * Created by Michał Mnich on 25.10.2016.
 */
public class MainWorker {

  public static void main(final String[] args){
    WebSocketWorkerNode workerSerwer = new WebSocketWorkerNode();

    if(args.length ==0){
      Iui ui = new ConsoleUi(workerSerwer);
      ui.InitRUnCMC();
    }
    else
    {
      if(args[0]!=null){

        // You can now use argCmd as needed
        System.out.println("Received command argument: " + Arrays.toString(args));
        // Optionally, pass argCmd to consoleImmputTask or store it
        //System.out.println("debug Test:"+args[0]);
        //System.out.println("debug Test:"+args[1]);

        if(args[0].equals("worker_up:") ) {
          workerSerwer.Start(Integer.valueOf(args[1]));
        }
        else if(args[0].equals("arg_cmd") ) {
          Iui ui = new ConsoleUi(workerSerwer,args[1]);
          ui.InitRUnCMC();
        }
      }
    }



  }


}
