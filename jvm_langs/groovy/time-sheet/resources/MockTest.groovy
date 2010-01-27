class MockTest extends GroovyTestCase {
    void testMockFor(){
        stub = new MockFor(DAO.class)
        stub.demand.save() { "Saved by mock 2" }
    

        ts = new TimeSheet()

        stub.use(new DAO()) {
        
            ts.register("Felipe").shouldBe "Saved by mock 2"
        }
    }
}
