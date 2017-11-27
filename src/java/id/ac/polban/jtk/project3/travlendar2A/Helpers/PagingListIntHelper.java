/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class PagingListIntHelper 
{
    // maks page, didapat dari database / pengguna yg menentukan
    private final int maxPage;
    // maks panjang paging
    private final int maxPaging;
    
    /**
     * Kontruktor
     * 
     * @param maxPage 
     * @param maxPaging 
     */
    public PagingListIntHelper(int maxPage, int maxPaging)
    {
        this.maxPage = maxPage;
        this.maxPaging = maxPaging;
    }
    
    /**
     * @return the maxPage
     */
    public int getMaxPage() 
    {
        return maxPage;
    }
    
    /**
     * Method untuk mendapatkan index
     * dengan basis 10
     * 
     * @param page
     * @return 
     */
    public int getIndex(int page)
    {
        int index;
        
        // index merupakan sisa pembangian page dg 10
        // dikurang satu karena indeks list mulai dari nol
        index = (page%10)-1;
        
        // jika tidak ada sisa, posisinya habis dibagi 10
        if(index == -1)
            index = 9;
        
        return index;
    }
    
    /**
     * Fungsi untuk mendapatkan list int
     * dengan current page bernilai null
     * 
     * @param currentPage
     * @return 
     */
    public List<Integer> getList(int currentPage)
    {   
        if(currentPage > this.maxPage)
            return null;
        
        int index; // index dari current page
        int initPaging;
        int temp;
        int maxloop;
        List<Integer> listPg; // list int untuk paging
           
        listPg = new ArrayList();
        // mendapatkan indeks dari current page
        index = this.getIndex(currentPage);
        // mendapatkan nilai pada indeks nol
        initPaging = currentPage - (index+1);
        // menentukan maksimal loop
        if((initPaging+10) < this.getMaxPage())
            maxloop = this.maxPaging;
        else
            maxloop = this.getIndex(this.getMaxPage());
        
        for(int i=0; i<maxloop; i++)
        {
            temp = i+1+initPaging; // isi list
            listPg.add(temp);
        }
        // mengganti current page dengan null
        listPg.remove(index);
        listPg.add(index, null);

        return listPg;
    }
}