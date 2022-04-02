package com.rickmorty.challenge.usecase.impl;


class CharacterServiceImplTest {

//    @InjectMocks
//    private CharacterServiceImpl characterService;
//    @Mock
//    private RestConnectionManager restConnectionManager;
//    private CharacterDto characterDto;
//    private OriginDto originDto;
//    private ResponseEntity<Object> responseEntity;
//    private ResponseEntity<Object> responseEntity2;
//
//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.openMocks(this);
//        setCharacterDto();
//        originDto = new OriginDto();
//        originDto.setUrl("www.myurl.com");
//        originDto.setName("Earth");
//        characterDto.setOrigin(originDto);
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON);
//        responseEntity = new ResponseEntity<>(characterDto, header, HttpStatus.OK);
//        responseEntity2 = new ResponseEntity<>(originDto, header, HttpStatus.OK);
//        ReflectionTestUtils.setField(characterService,"mapper", new ObjectMapper());
//    }
//
//    public void setCharacterDto(){
//        characterDto = new CharacterDto();
//        characterDto.setName("Jan");
//        characterDto.setId(22);
//        characterDto.setSpecies("Human");
//        characterDto.setStatus("Alive");
//        characterDto.setType("type1");
//        characterDto.setEpisode_count(2);
//        String episode[] = new String[2];
//        episode[0] = "https://rickandmortyapi.com/api/episode/45";
//        episode[1] = "https://rickandmortyapi.com/api/episode/32";
//        characterDto.setEpisode(episode);
//    }
//
//    @Test
//    public void testCharacterServiceImpReturnsExpectedValues(){
//        Mockito.when(restConnectionManager.getObjectFromWebAPI("https://rickandmortyapi.com/api/character/2")).thenReturn(responseEntity);
//        Mockito.when(restConnectionManager.getObjectFromWebAPI("www.myurl.com")).thenReturn(responseEntity2);
//        CharacterDto testCharacterDto = characterService.getCharacterDto("2");
//        Assertions.assertEquals(characterDto.getName(), testCharacterDto.getName());
//        Assertions.assertEquals(characterDto.getId(), testCharacterDto.getId());
//        Assertions.assertEquals(characterDto.getSpecies(), testCharacterDto.getSpecies());
//        Assertions.assertEquals(characterDto.getStatus(), testCharacterDto.getStatus());
//        Assertions.assertEquals(characterDto.getType(), testCharacterDto.getType());
//        Assertions.assertEquals(characterDto.getEpisode_count(), testCharacterDto.getEpisode_count());
//    }

}