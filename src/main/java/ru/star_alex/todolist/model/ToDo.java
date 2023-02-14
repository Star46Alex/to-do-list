package ru.star_alex.todolist.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "to_do")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String description;
  private long date;

  public String getDate() {
    Date date= new Date(this.date*1000);
    SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
    return  sm.format(date);
  }
  public void setDate( String date) {
    try {
      LocalDate d = LocalDate.parse(date);
      ZoneOffset zone = ZoneOffset.of("Z");
      LocalTime time = LocalTime.parse("00:00:00");
      this.date = d.toEpochSecond(time, zone);
    }
    catch (Exception e){
      System.out.println(e.getMessage());
      System.out.println(date);
    }
  }
}
