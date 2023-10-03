const App = () => {
  
  const onClickHandler = () => {
    window.location.href = ("https://www.google.co.in");
  };

  return (
    <div>
      <h1>
        App
      </h1>
      <button onClick={onClickHandler}>Click</button>
    </div>
  )
}

export default App;