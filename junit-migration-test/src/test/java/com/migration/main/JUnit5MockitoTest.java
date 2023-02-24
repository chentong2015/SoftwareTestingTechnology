package com.migration.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// @ExtendWith(MockitoExtension.class)
//
// 使用Mockito基于Junit5的实现，需要在添加MockitoExtension的情况下使用
// @Mock
// UserRepository userRepository;
class JUnit5MockitoTest {

    @Test
    void testMockitoJUnit() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.getUsername()).thenReturn("test");
        Assertions.assertEquals("test", userRepository.getUsername());
    }

    // 使用纯mockito依赖搭配Junit4或者Junit5
    // @Test
    void testMockitoJUnit4() {
        UserRepository userRepository1 = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository1.getUsername()).thenReturn("test");
        Assertions.assertEquals("test", userRepository1.getUsername());
    }

}
