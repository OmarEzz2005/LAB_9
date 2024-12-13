/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BackEnd;

/**
 *
 * @author lenovo
 */
public interface Database <T> {
    public void saveToFile();
    public void readFromFile();
    public T getRecord(String key);
    public void deleteRecord(String key);
    public boolean contains(String key);
}
