package fworks.algorithms.data.bag;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class BagLinkedListImplTest extends AbstractBagTest {

  @Test
  public void testStringBag() {
    log.info("####### Testing String bag!");
    Bag<String> bag = new BagLinkedListImpl<String>();
    super.validateString(bag, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerBag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagLinkedListImpl<Integer>();
    super.validateInteger(bagInteger, 50);
  }
  
  @Test
  public void testInteger2Bag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagLinkedListImpl<Integer>();
    super.validateInteger(bagInteger, 5000);
  }
}