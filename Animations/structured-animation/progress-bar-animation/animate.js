function animate({duration, draw, timing}) {

    let start = performance.now();
    console.log("START: ", start);

    requestAnimationFrame(function animate(time) {
      let timeFraction = (time - start) / duration;
      console.log("Time: ", time);
      if (timeFraction > 1) {
        console.log("TIME FRACTION GREATER");
        timeFraction = 1;
      }
      console.log("Duration: ", duration);
      let progress = timing(timeFraction)
  
      draw(progress);
  
      if (timeFraction < 1) {
        console.log("TIME FRACTION LESSER");
        requestAnimationFrame(animate);
      }
    });
  }