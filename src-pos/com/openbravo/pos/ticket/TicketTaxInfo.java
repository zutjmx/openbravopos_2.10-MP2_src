//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.ticket;

import com.openbravo.format.Formats;


public class TicketTaxInfo {
    
    private TaxInfo m_TaxInfo;
    private double m_dSubTotal;
            
    /** Creates a new instance of TicketTaxInfo */
    public TicketTaxInfo(TaxInfo t) {
        m_TaxInfo = t;
        m_dSubTotal = 0.0;
    }
    
    public TaxInfo getTaxInfo() {
        return m_TaxInfo;
    }
    
    public void add(double dValue) {
        m_dSubTotal += dValue;
    }
    
    public double getSubTotal() {    
        return m_dSubTotal;
    }
    
    public double getTax() {       
        return m_dSubTotal * m_TaxInfo.getRate();
    }
    
    public double getTotal() {         
        return m_dSubTotal * (1 + m_TaxInfo.getRate());
    }
    
    public String printSubTotal() {
        return Formats.CURRENCY.formatValue(new Double(getSubTotal()));
    }
    public String printTax() {
        return Formats.CURRENCY.formatValue(new Double(getTax()));
    }    
    public String printTotal() {
        return Formats.CURRENCY.formatValue(new Double(getTotal()));
    }    
}
