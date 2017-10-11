package id.ac.polban.jtk.project3.travlendar2A.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class Moda_Transportasi {
    private int speedKendaraan;
    private boolean availableTransportation;
    public enum nama_transportasi{
        MOBIL, MOTOR, PESAWAT, KERETA, BUS;
    }
    
    public void setIsTransportAvailable(boolean availableTransportation){
        this.availableTransportation = availableTransportation;
    }
    
    public boolean getIsTransportAvailable(){
        return availableTransportation;
    }
    
    public double getSpeedKendaraan (nama_transportasi vhc){
        switch(vhc){
            //satuan kecepatan adalah km/jam
            case MOBIL :
                speedKendaraan = 50; //set speed untuk mobil
                break;
            case MOTOR :
                speedKendaraan = 60; //set speed untuk motor
                break;
            case PESAWAT :
                speedKendaraan = 900; //set speed untuk pesawat
                break;
            case KERETA :
                speedKendaraan = 150; //set speed untuk kereta
                break;
            case BUS : //set speed untuk bus
                speedKendaraan = 40;
                break;
        }
        return speedKendaraan;
    }
    
    public void transportRecomendation(double distance, double waktuKosong){
        double[] arrayOfEta = new double [5]; //array untuk menampung variabel estimation time arrival (eta)
        Moda_Transportasi tm = new Moda_Transportasi();
        EstimasiWaktu et = new EstimasiWaktu();
        Lokasi loc = new Lokasi();
        Agenda event = new Agenda();
        boolean noTransport = true;
        et.setDistance(distance);
        arrayOfEta[0] = et.countEstimationTime(tm.getSpeedKendaraan(nama_transportasi.PESAWAT),et.getDistance()); //var penampung estimation jika menggunakan pesawat
        arrayOfEta[1] = et.countEstimationTime(tm.getSpeedKendaraan(nama_transportasi.KERETA),et.getDistance()); //var penampung estimation jika menggunakan kereta
        arrayOfEta[2] = et.countEstimationTime(tm.getSpeedKendaraan(nama_transportasi.MOTOR),et.getDistance());  //var penampung estimation jika menggunakan motor
        arrayOfEta[3] = et.countEstimationTime(tm.getSpeedKendaraan(nama_transportasi.MOBIL),et.getDistance());  //var penampung estimation jika menggunakan mobil
        arrayOfEta[4] = et.countEstimationTime(tm.getSpeedKendaraan(nama_transportasi.BUS),et.getDistance());    //var penampung estimation jika menggunakan bus
        System.out.println("\nRekomendasi kendaraan yang dapat digunakan: \n");
        for (int i=0; i<5; i++){
            if (arrayOfEta[i]<=waktuKosong){    //pengecekan jika waktu yg diperlukan ketika menaiki kendaraan lebih kecil dari waktu kosong yang dimiliki
                noTransport=false;
                switch(i){
                    case 0: 
                        if (!(loc.bisaDilaluiPesawat(event.getKodeLokasiAwal(), event.getKodeLokasiTujuan()))){
                            System.out.print("-> Pesawat, waktu tempuh ");
                            et.printEstimationTime(arrayOfEta[i]);
                            System.out.println("\n");
                        } else {
                            
                        }
                        break;
                    case 1:
                        System.out.print("-> Kereta, waktu tempuh ");
                        et.printEstimationTime(arrayOfEta[i]);    
                        System.out.println("\n");
                        break;
                    case 2:
                        System.out.print("-> Motor, waktu tempuh ");
                        et.printEstimationTime(arrayOfEta[i]);
                        System.out.println("\n");
                        break;
                    case 3:
                        System.out.print("-> Mobil, waktu tempuh ");
                        et.printEstimationTime(arrayOfEta[i]);
                        System.out.println("\n");
                        break;
                    case 4:
                        System.out.print("-> Bus, waktu tempuh ");
                        et.printEstimationTime(arrayOfEta[i]);
                        System.out.println("\n");
                        break;
                }
            } else {
                    if(noTransport){
                        System.out.println("Interval waktu keberangkatan dengan waktu tiba "
                                + "terlalu sedikit, silahkan ubah waktu keberangkatan "
                                + "menjadi lebih cepat untuk mendapat rekomendasi kendaraan yang cocok\n");
                        this.setIsTransportAvailable(true);
                        break;
                    } 
                }
            }
        }
    }