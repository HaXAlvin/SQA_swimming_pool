package main;

import org.junit.jupiter.api.*;
public class IdentityTest {
    @DisplayName("年紀賦值測試")
    @Nested
    class AgeTest {
        @Test
         void ageGetterTest() {
            Identity identity = new Identity(25, false, false);
            Assertions.assertEquals(25, identity.getAge());
        }
        @Test
         void ageSetterTest() {
            Identity identity = new Identity(25, false, false);
            identity.setAge(10);
            Assertions.assertEquals(10, identity.getAge());
        }
    }
    @DisplayName("會員賦值測試")
    @Nested
    class MemberTest {
        @Test
         void memberGetterTest() {
            Identity identity = new Identity(25, true, false);
            Assertions.assertTrue(identity.isMember());
        }
        @Test
         void memberSetterTest() {
            Identity identity = new Identity(25, true, false);
            identity.setMember(false);
            Assertions.assertFalse(identity.isMember());
        }
    }
    @DisplayName("團體賦值測試")
    @Nested
    class GroupTest {
        @Test
         void groupGetterTest() {
            Identity identity = new Identity(25, false, true);
            Assertions.assertTrue(identity.isGroup());
        }
        @Test
         void groupSetterTest() {
            Identity identity = new Identity(25, false, true);
            identity.setGroup(false);
            Assertions.assertFalse(identity.isGroup());
        }
    }
}
