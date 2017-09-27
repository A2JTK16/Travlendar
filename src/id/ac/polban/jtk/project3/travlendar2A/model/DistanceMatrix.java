/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.model;

/**
 *
 * @author Auliya Aqma Dinillah
 */
public class DistanceMatrix {
    /**
     * REVIEW 
     * 
     * 1.   Kota_awal dan kota_tujuan Bentuk Integer Saja, Tidak Memerlukan String.
     *      Selanjutnya, Kode Kota Tersebut Diubah Menjadi Alamat Indeks Array,
     *      Lalu Kembalikan Isi Array Tersebut.
     * 2.   Kota Bisa Pakai 'enum' untuk Memudahkan
     * 3.   Diperlukan Method untuk Mengembalikan Nilai Jarak
     * 4.   Lebih Baik Teknik Mendapatkan Jarak Pakai Indeks Array Saja Langsung,
     *      Tidak Memerlukan Nested Loop Karena Kode Kota Tidak Berubah dan
     *      Memiliki Keterkaitan dengan Indeks Array 
     *      Contoh : Array jarak[1][2] Berisi Jarak Bandung - Bekasi
     */
    
    //deklarasi atribut
    double distance;
    private double jarak_lokasi;
    private int  kode_kota1;
    private int kode_kota2;
    /*private double [][] jarak = {{0,	134,	177,	135,	160,	209,	149,	201,	89.4,	244,	192,	202,	53.3,	118,	90.1,	71.1,	126},
                               {132,	0,	62.2,	248,	208,	200,	199,	192,	54.2,	236,	183,	316,	78.4,	110,	173,	184,	240},
                               {212,    81.8,   0,      305,	175,    247,    319,	249,	110,	292,	239,	372,	135,	166,	140,	241,	296},
                               {125,	237,	306,	0,	233,	116,	155,	152,	214,	85.6,	95.5,	68.5,	178,	184,	310,	103,	19.6},
                               {101,	196,	176,	230,	0,	295,	123,	297,	186,	341,	288,	238,	170,	215,	119,	151,	217},
                               {229,	178,	257,	105,	345,	0,	221,	55.4,	165,	43.9,	51.5,	181,	162,	129,	276,	93.2,	111},
                               {157,	250,	318,	109,	125,	213,	0,	223,	226,	170,	182,	163,	190,	225,	213,	141,	90.1},
                               {207,	192,	247,	152,	336,	55.7,	222,	0,	155,	103,	64,	232,	153,	79.5,	358,	93.4,	149},
                               {93.2,	29.9,	106,	208,	221,	150,	222,	152,	0,	195,	142,	274,	37.8,	61.7,	217,	144,	199},
                               {252,	223,	291,	82.5,	379,	52.1,	188,	104,	19,	0,	60.8,	142,	196,	163,	402,	127,	87.9},
                               {199,	171,	238,	92.4,	327,	41.4,	181,	63.1,	146,	60.4,	0,	152,	143,	110,	349,	53.2,	91.5},
                               {193,	296,	364,	68.6,	241,	167,	163,	205,	272,	136,	146,	0,	245,	236,	329,	171,	85.6},
                               {59,	64.9,	132,	137,	187,	150,	187,	152,	40.5,	195,	143,	241,	0,	69.3,	243,	144,	165},
                               {127,	94.8,	166,	184,	255,	119,	255,	78.7,	74,	164,	111,	244,	71.4,	0,	277,	113,	184},
                               {167,	193,	139,	282,	119,	358,	214,	360,	222,	403,	350,	329,	170,	277,	0,	218,	273},
                               {71.4,	172,	239,	104,	162,	92.1,	133,	92.6,	147,	128,	53.2,	171,	108,	112,	241,	0,	95.2},
                               {119,	231,	299,	19.6,	218,	119,	140,	151,	207,	88.8,	92.4,	84.7,	171,	183,	208,	96.8,	0},
                             };*/
   private double [][] jarak = {{0,	40,	98,	847,	875.3,	904.6},
                                {40,	0,	58,	807,	835.3,	864.6},
                                {98,	58,	0,	749,	777.3,	806.6},
                                {847,	807,	750,	0,	28.3,	35.4},
                                {875.3,	785,	734,	29.,	0,	29.3},
                                {904.6,	864,6,	806.6,	35.4,	29.3,	0},
                                };
 /*
     * @return the jarak
     */
    public double[][] getJarak() {
        return jarak;
    }
    public double getdistance(){
        return distance;
    }
    /**
     * @param jarak the jarak to set
     */
    public void setJarak(double[][] jarak) {
        this.jarak = jarak;
    }

    /**
     * @param kode_kota1 the kode_kota1 to set
     */
    public void setKode_kota1(int kode_kota1) {
        this.kode_kota1 = kode_kota1;
    }

    /**
     * @return the kode_kota2
     */
    public int getKode_kota2() {
        return kode_kota2;
    }

    /**
     * @param kode_kota2 the kode_kota2 to set
     */
    public void setKode_kota2(int kode_kota2) {
        this.kode_kota2 = kode_kota2;
    }

    /**
     * @return the jarak_lokasi
     */
    //method return jarak_lokasi
    public double getJarak_lokasi() {
        this.jarak_lokasi = getJarak()[kode_kota1][kode_kota2];
        return jarak_lokasi;
    }

    /**
     * @param jarak_lokasi the jarak_lokasi to set
     */
    public void setJarak_lokasi(int jarak_lokasi) {
        this.jarak_lokasi = jarak_lokasi;
    }
}