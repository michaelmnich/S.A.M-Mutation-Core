package org.pitest.mutationtest.sam.ui.console;

import org.pitest.extensions.MutationRandomizerSingleton;
import org.pitest.mutationtest.DetectionStatus;
import org.pitest.mutationtest.sam.config.FromFileMetaData;
import org.pitest.mutationtest.statistics.Score;
import org.pitest.mutationtest.statistics.StatusCount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashMap;

public class FileRaportGeneratorHelper {
    
    
    public static String AppendRaport(FromFileMetaData data, Instant start, Instant end)
    {
        String str = "";
        try{
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("-----------------------------------------------------------");
        System.out.println("MUTACJA TQED DLA: "+ data.Classname + " PLIK " + data.FileName);
        System.out.println("-----------------------------------------------------------");

        MutationRandomizerSingleton.ActualClass =data.Classname;

        Duration timeElapsed = Duration.between(start, end);

        java.util.HashMap<DetectionStatus,Long> mapaDanych  = new HashMap<DetectionStatus, Long>();

        mapaDanych.put(DetectionStatus.KILLED,new Long(0));
        mapaDanych.put(DetectionStatus.SURVIVED,new Long(0));
        mapaDanych.put(DetectionStatus.NO_COVERAGE,new Long(0));
        mapaDanych.put(DetectionStatus.TIMED_OUT,new Long(0));
        mapaDanych.put(DetectionStatus.MEMORY_ERROR,new Long(0));
        mapaDanych.put(DetectionStatus.RUN_ERROR,new Long(0));
        mapaDanych.put(DetectionStatus.NON_VIABLE,new Long(0));
        mapaDanych.put(DetectionStatus.NOT_STARTED,new Long(0));
        mapaDanych.put(DetectionStatus.STARTED,new Long(0));

        String LIne="";
        if(MutationRandomizerSingleton.GlobalStats!=null){

            for (Score sorce : MutationRandomizerSingleton.GlobalStats.getScores())
            {
                Iterable<StatusCount>  counts = sorce.GetCounts();
                long totalmut = sorce.getTotalMutations();
                // sorce.report().;

                for (StatusCount status: counts) {
                    if(status.getStatus().equals(DetectionStatus.KILLED)){ //1
                        mapaDanych.put(DetectionStatus.KILLED,mapaDanych.get(DetectionStatus.KILLED)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.SURVIVED)){//2
                        mapaDanych.put(DetectionStatus.SURVIVED,mapaDanych.get(DetectionStatus.SURVIVED)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.NO_COVERAGE)){ //3
                        mapaDanych.put(DetectionStatus.NO_COVERAGE,mapaDanych.get(DetectionStatus.NO_COVERAGE)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.TIMED_OUT)){ //4
                        mapaDanych.put(DetectionStatus.TIMED_OUT,mapaDanych.get(DetectionStatus.TIMED_OUT)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.MEMORY_ERROR)){ //5
                        mapaDanych.put(DetectionStatus.MEMORY_ERROR,mapaDanych.get(DetectionStatus.MEMORY_ERROR)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.RUN_ERROR)){//6
                        mapaDanych.put(DetectionStatus.RUN_ERROR,mapaDanych.get(DetectionStatus.RUN_ERROR)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.NON_VIABLE)){//7
                        mapaDanych.put(DetectionStatus.NON_VIABLE,mapaDanych.get(DetectionStatus.NON_VIABLE)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.NOT_STARTED)){//8
                        mapaDanych.put(DetectionStatus.NOT_STARTED,mapaDanych.get(DetectionStatus.NOT_STARTED)+ status.getCount());
                    }
                    if(status.getStatus().equals(DetectionStatus.STARTED)){//9
                        mapaDanych.put(DetectionStatus.STARTED,mapaDanych.get(DetectionStatus.STARTED)+ status.getCount());
                    }
                }
            }

        }else{
            LIne ="0;0;0;0;0;0;0;0;0;0";
        }

        LIne=";"+mapaDanych.get(DetectionStatus.KILLED)+
                ";"+mapaDanych.get(DetectionStatus.SURVIVED)+
                ";"+mapaDanych.get(DetectionStatus.NO_COVERAGE)+
                ";"+mapaDanych.get(DetectionStatus.MEMORY_ERROR)+
                ";"+mapaDanych.get(DetectionStatus.RUN_ERROR)+
                ";"+mapaDanych.get(DetectionStatus.NON_VIABLE)+
                ";"+mapaDanych.get(DetectionStatus.NOT_STARTED)+
                ";"+mapaDanych.get(DetectionStatus.STARTED);


        str +=""+data.FileName+";"+ data.Classname +";"+timeElapsed.toMillis()+";OK"
                +";"+MutationRandomizerSingleton.TestRan
                +";"+MutationRandomizerSingleton.GlobalTestsPermut
                +LIne
                +System.lineSeparator();


        }catch (Exception e){
            str +=""+ data.Classname +";-1;ClassError;-1;-1;-1;-1;-1;-1;-1;-1;-1;-1;-1"+System.lineSeparator();
        }
        finally {
            return str;
        }
    }
    
}