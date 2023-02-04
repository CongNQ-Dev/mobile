import 'package:flutter/material.dart';

void main() {
  runApp(CounterApp());
}

class CounterApp extends StatelessWidget {
  const CounterApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
            centerTitle: false,
            title: Text(
              "Counter App",
            )),
        body: Center(
          child: Text("Hello",
              style: TextStyle(fontSize: 30, color: Colors.blue[300])),
        ),
      ),
    );
  }
}
