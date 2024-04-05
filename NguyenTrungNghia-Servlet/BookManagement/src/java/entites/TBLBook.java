/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "TBL_Book")
@NamedQueries({
    @NamedQuery(name = "TBLBook.findAll", query = "SELECT t FROM TBLBook t"),
    @NamedQuery(name = "TBLBook.findByBookId", query = "SELECT t FROM TBLBook t WHERE t.bookId = :bookId"),
    @NamedQuery(name = "TBLBook.findByBookTitle", query = "SELECT t FROM TBLBook t WHERE t.bookTitle = :bookTitle"),
    @NamedQuery(name = "TBLBook.findByBookAuthor", query = "SELECT t FROM TBLBook t WHERE t.bookAuthor = :bookAuthor"),
    @NamedQuery(name = "TBLBook.findByBookPrice", query = "SELECT t FROM TBLBook t WHERE t.bookPrice = :bookPrice")})
public class TBLBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookId")
    private Integer bookId;
    @Basic(optional = false)
    @Column(name = "BookTitle")
    private String bookTitle;
    @Basic(optional = false)
    @Column(name = "BookAuthor")
    private String bookAuthor;
    @Basic(optional = false)
    @Column(name = "BookPrice")
    private int bookPrice;

    public TBLBook() {
    }

    public TBLBook(Integer bookId) {
        this.bookId = bookId;
    }

    public TBLBook(Integer bookId, String bookTitle, String bookAuthor, int bookPrice) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBLBook)) {
            return false;
        }
        TBLBook other = (TBLBook) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TBLBook[ bookId=" + bookId + " ]";
    }
    
}
